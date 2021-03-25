package com.dilfer.discord.bot;

import com.dilfer.gamemanager.GameManager;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.object.presence.Activity;
import discord4j.core.object.presence.Presence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameServerManagerBotRunner
{
    private static final Logger logger = LoggerFactory.getLogger(GameServerManagerBotRunner.class);

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            throw new RuntimeException("Incorrect arguments supplied. This class requires two arguments; the discord bot token followed by the API Gateway token.");
        }

        String discordToken = args[0];
        String apiGatewayToken = args[1];
        DiscordClientBuilder builder = new DiscordClientBuilder(discordToken)
                .setInitialPresence(Presence.online(Activity.playing("!manager help")));
        DiscordClient client = builder.build();
        GameManager discordBotApi = GameManager.builder().apiKey(apiGatewayToken).build();
        GameServerManagerBot discordBot = new GameServerManagerBot(discordBotApi, client);
        addLogoutShutdownHook(client);
        discordBot.run();
    }

    private static void addLogoutShutdownHook(DiscordClient client) {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            logger.info("W: interrupt received, logging out.");
            client.logout().block();
            logger.info("Successfully logged out.");
        }));
    }
}
