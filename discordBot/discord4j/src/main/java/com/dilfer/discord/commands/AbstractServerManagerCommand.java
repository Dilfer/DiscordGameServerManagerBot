package com.dilfer.discord.commands;

import com.dilfer.gamemanager.GameManager;
import com.dilfer.gamemanager.model.GameManagerException;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.MessageChannel;
import reactor.core.publisher.Mono;

import java.util.List;

abstract class AbstractServerManagerCommand implements ServerCommand
{
    private final String commandString;
    private final String infoMessage;
    private final List<String> expectedArguments;

    public AbstractServerManagerCommand(String commandString,
                                        String infoMessage,
                                        List<String> expectedArguments)
    {
        this.commandString = commandString;
        this.infoMessage = infoMessage;
        this.expectedArguments = expectedArguments;
    }

    @Override
    public String getCommandString()
    {
        return commandString;
    }

    @Override
    public String getInfoMessage()
    {
        return infoMessage;
    }

    @Override
    public List<String> getArguments()
    {
        return expectedArguments;
    }

    abstract String callApiAndGetUserFriendlyMessage(List<String> suppliedArguments, Guild guild, GameManager discordBotApi);

    @Override
    public Mono<Message> run(MessageChannel messageChannel, GameManager discordBotApi, Guild guild, String message)
    {
        try
        {
            List<String> arguments = ArgumentValidator.getArguments(this, message);
            return messageChannel.createMessage(callApiAndGetUserFriendlyMessage(arguments, guild, discordBotApi));
        }
        catch (GameManagerException | InvalidArgumentsException e)
        {
            return messageChannel.createMessage(e.getMessage());
        }
    }
}
