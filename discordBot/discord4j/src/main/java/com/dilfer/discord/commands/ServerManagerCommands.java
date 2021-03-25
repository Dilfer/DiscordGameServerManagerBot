package com.dilfer.discord.commands;

import com.dilfer.gamemanager.GameManager;
import com.dilfer.gamemanager.model.*;
import discord4j.core.object.entity.Guild;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum ServerManagerCommands
{
    start(new StartServerCommand("!manager start", "Used to start the specific game server and returns the IP address used to connect. Run the listgames command to view a list of available games.", Collections.singletonList("game"))),
    stop( new StopServerCommand("!manager stop", "Used to stop the specific game server to save Dilfer money. Run the listgames command to view a list of available games.", Collections.singletonList("game"))),
    info(new InfoServerCommand("!manager info", "Returns general information about the current state of the specific game server. Run the listgames command to view a list of available games.", Collections.singletonList("game"))),
    list_games(new ListGamesServerCommand("!manager listgames", "Returns a list of the games related to this Discord server.", Collections.emptyList()));

    private final ServerCommand serverCommand;

    ServerManagerCommands(ServerCommand serverCommand)
    {
        this.serverCommand = serverCommand;
    }

    public ServerCommand getServerCommand()
    {
        return serverCommand;
    }

    public static List<ServerCommand> getServerManagerCommands()
    {
        return Arrays.stream(ServerManagerCommands.values())
                .map(ServerManagerCommands::getServerCommand)
                .collect(Collectors.toList());
    }

    private static class StartServerCommand extends AbstractServerManagerCommand
    {
        private StartServerCommand(String commandString,
                                  String infoMessage,
                                  List<String> expectedArguments)
        {
            super(commandString, infoMessage, expectedArguments);
        }

        @Override
        String callApiAndGetUserFriendlyMessage(List<String> suppliedArguments, Guild guild, GameManager discordBotApi)
        {
            String game = suppliedArguments.iterator().next();
            PostServermanagerStartserverRequest startServerRequest = new PostServermanagerStartserverRequest()
                    .startServerRequest(new StartServerRequest()
                            .game(game)
                            .guild(guild.getName()));

            PostServermanagerStartserverResult startResult = discordBotApi.postServermanagerStartserver(startServerRequest);
            StartServerResponse startServerResponse = startResult.getStartServerResponse();
            return String.format("The %s server has transitioned from %s to %s",
                    game,
                    startServerResponse.getOriginalState(),
                    startServerResponse.getNewState());
        }
    }

    private static class StopServerCommand extends AbstractServerManagerCommand
    {
        private StopServerCommand(String commandString,
                                  String infoMessage,
                                  List<String> expectedArguments)
        {
            super(commandString, infoMessage, expectedArguments);
        }

        @Override
        String callApiAndGetUserFriendlyMessage(List<String> suppliedArguments, Guild guild, GameManager discordBotApi)
        {
            String game = suppliedArguments.iterator().next();
            PostServermanagerStopserverRequest stopRequest = new PostServermanagerStopserverRequest()
                    .stopServerRequest(new StopServerRequest()
                            .game(game)
                            .guild(guild.getName()));

            PostServermanagerStopserverResult stopResult = discordBotApi.postServermanagerStopserver(stopRequest);
            StopServerResponse stopServerResponse = stopResult.getStopServerResponse();
            return String.format("The %s server has transitioned from %s to %s",
                    game,
                    stopServerResponse.getOriginalState(),
                    stopServerResponse.getNewState());
        }
    }

    private static class InfoServerCommand extends AbstractServerManagerCommand
    {
        private InfoServerCommand(String commandString,
                                 String infoMessage,
                                 List<String> expectedArguments)
        {
            super(commandString, infoMessage, expectedArguments);
        }

        @Override
        String callApiAndGetUserFriendlyMessage(List<String> suppliedArguments, Guild guild, GameManager discordBotApi)
        {
            String game = suppliedArguments.iterator().next();
            PostServermanagerServerinfoRequest request = new PostServermanagerServerinfoRequest().serverInfoRequest(new ServerInfoRequest()
                    .game(game)
                    .guild(guild.getName()));
            PostServermanagerServerinfoResult serverInfo = discordBotApi.postServermanagerServerinfo(request);
            ServerInfoResponse response = serverInfo.getServerInfoResponse();
            return String.format("The %s server is in the %s state with public IP %s", game, response.getInstanceState(), response.getIpAddress());
        }
    }

    private static class ListGamesServerCommand extends AbstractServerManagerCommand
    {
        private ListGamesServerCommand(String commandString, String infoMessage, List<String> expectedArguments)
        {
            super(commandString, infoMessage, expectedArguments);
        }

        @Override
        String callApiAndGetUserFriendlyMessage(List<String> suppliedArguments, Guild guild, GameManager discordBotApi)
        {
            PostServermanagerListgamesRequest request = new PostServermanagerListgamesRequest()
                    .listGamesRequest(new ListGamesRequest()
                            .guild(guild.getName()));

            PostServermanagerListgamesResult servermanagerListgames = discordBotApi.postServermanagerListgames(request);
            ListGamesResponse response = servermanagerListgames.getListGamesResponse();
            return String.format("The discord guild %s is configured for the following games : %s", guild, response.getGames());
        }
    }
}
