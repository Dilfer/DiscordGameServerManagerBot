package com.dilfer.discord.bot;

import com.dilfer.discord.commands.HelpCommand;
import com.dilfer.discord.commands.ServerCommand;
import com.dilfer.discord.commands.ServerManagerCommands;
import com.dilfer.gamemanager.GameManager;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Supplier;

public class GameServerManagerBot
{
    private static final Logger logger = LoggerFactory.getLogger(GameServerManagerBot.class);

    private final GameManager discordBotApi;
    private final DiscordClient client;

    public GameServerManagerBot(GameManager discordBotApi,
                                DiscordClient client)
    {

        this.discordBotApi = discordBotApi;
        this.client = client;
    }

    public void run()
    {
        logger.info("Registering all commands.");
        registerServerManagerCommands();
        registerHelpCommand();
        loginAndBlockThread(client);
    }

    private void registerServerManagerCommands()
    {
        for (ServerCommand command : ServerManagerCommands.getServerManagerCommands())
        {
            client.getEventDispatcher().on(MessageCreateEvent.class)
                    .map(MessageCreateEvent::getMessage)
                    .filter(GameServerManagerBot::messageIsFromNormalUser)
                    .filter(message -> message.getContent().orElse("").startsWith(command.getCommandString()))
                    .flatMap(message -> runCommand(discordBotApi, command, message))
                    .subscribe();
        }
    }

    private void registerHelpCommand()
    {
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filter(GameServerManagerBot::messageIsFromNormalUser)
                .filter(message -> HelpCommand.CMD_MESSAGE.equals(message.getContent().orElse("")))
                .flatMap(message -> new HelpCommand().run(Objects.requireNonNull(message.getChannel().block())))
                .subscribe();
    }

    private static boolean messageIsFromNormalUser(Message message)
    {
        return message.getAuthor().map(user -> !user.isBot()).orElse(false);
    }

    private static Mono<Message> runCommand(GameManager discordBotApi, ServerCommand command, Message message)
    {
        Guild guild = message.getGuild().block();

        try
        {
            return command.run(message.getChannel().block(),
                    discordBotApi,
                    Objects.requireNonNull(guild),
                    message.getContent().orElseThrow(throwRuntime()));
        }
        catch (NullPointerException e)
        {
            logger.error("Received a null pointer exception from message : " + message.getContent().orElse("UNKNOWN"));
            return message.getChannel()
                    .flatMap(channel -> channel.createMessage("Bot encountered an err0rz and could not retrieve the server/guild name."));
        }
    }

    private static Supplier<RuntimeException> throwRuntime()
    {
        return () -> new RuntimeException("Message content is empty somehow when trying to run command.");
    }

    private static void loginAndBlockThread(DiscordClient client)
    {
        logger.info("Logging in.");
        client.login().block();
    }
}
