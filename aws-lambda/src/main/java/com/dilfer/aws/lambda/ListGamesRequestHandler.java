package com.dilfer.aws.lambda;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.util.json.Jackson;
import com.dilfer.gamemanager.model.ListGamesRequest;
import com.dilfer.gamemanager.model.ListGamesResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListGamesRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
{
    private final AmazonEC2 ec2;

    public ListGamesRequestHandler()
    {
        this.ec2 = AmazonEC2ClientBuilder.defaultClient();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context)
    {

        try {
            context.getLogger().log(Jackson.toJsonPrettyString(input));
            ListGamesRequest listGamesRequest = Jackson.fromJsonString(input.getBody(), ListGamesRequest.class);

            context.getLogger().log(String.format("Got a list games request for guild %s.",
                                                  listGamesRequest.getGuild()));

            List<String> guildGames = getGames(listGamesRequest.getGuild());
            ListGamesResponse response = new ListGamesResponse().games(guildGames);
            String jsonResponse = Jackson.toJsonString(response);
            context.getLogger().log("Sending response " + jsonResponse);
            return new APIGatewayProxyResponseEvent()
                    .withBody(jsonResponse)
                    .withStatusCode(200);
        } catch (Exception e) {
            context.getLogger().log("Got an exception" + e.getMessage());
            throw e;
        }
    }

    private List<String> getGames(String guild)
    {
        DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest()
                .withFilters(new Filter()
                        .withName("tag:DiscordGuild")
                        .withValues(guild.toLowerCase()));

        DescribeInstancesResult describeInstancesResult = ec2.describeInstances(describeInstancesRequest);

        return describeInstancesResult
                .getReservations()
                .stream()
                .map(Reservation::getInstances)
                .flatMap(Collection::stream)
                .map(Instance::getTags)
                .flatMap(Collection::stream)
                .filter(tag -> "Game".equalsIgnoreCase(tag.getKey()))
                .map(Tag::getValue)
                .collect(Collectors.toList());
    }
}
