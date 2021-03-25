package com.dilfer.aws.lambda;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.util.json.Jackson;
import com.dilfer.gamemanager.model.ServerInfoRequest;
import com.dilfer.gamemanager.model.ServerInfoResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ServerInfoRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
{
    private final Ec2ApiMarshaller ec2ApiMarshaller;

    public ServerInfoRequestHandler()
    {
        this.ec2ApiMarshaller = new Ec2ApiMarshaller(AmazonEC2ClientBuilder.defaultClient());
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context)
    {
        try {
            context.getLogger().log(Jackson.toJsonPrettyString(input));
            ServerInfoRequest serverInfoRequest = Jackson.fromJsonString(input.getBody(), ServerInfoRequest.class);
            context.getLogger().log(String.format("Got a server info request for guild %s and game %s. ",
                    serverInfoRequest.getGuild(),
                    serverInfoRequest.getGame()));
            ServerInfoResponse serverInfoResponse = ec2ApiMarshaller.marshallRequest(
                    ec2 -> getInstances(ec2, serverInfoRequest),
                    this::getInfoFromInstance);

            String jsonStringResponse = Jackson.toJsonString(serverInfoResponse);
            context.getLogger().log("Sending response " + jsonStringResponse);

            return new APIGatewayProxyResponseEvent()
                    .withBody(jsonStringResponse)
                    .withStatusCode(200);
        }
        catch (Exception e)
        {
            context.getLogger().log("Got an exception" + e.getMessage());
            throw e;
        }
    }

    private List<Instance> getInstances(AmazonEC2 ec2, ServerInfoRequest request)
    {
        DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest()
                .withFilters(new Filter().withName("tag:DiscordGuild").withValues(request.getGuild().toLowerCase()),
                             new Filter().withName("tag:Game").withValues(request.getGame().toLowerCase()));

        DescribeInstancesResult describeInstancesResult = ec2.describeInstances(describeInstancesRequest);
        return describeInstancesResult.getReservations().stream()
                .map(Reservation::getInstances)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private ServerInfoResponse getInfoFromInstance(Instance instance)
    {
        String instanceName = instance.getTags().stream()
                .filter(tag -> "name".equalsIgnoreCase(tag.getKey()))
                .map(Tag::getValue)
                .findFirst().orElse("unknown");
        return new ServerInfoResponse()
                .name(instanceName)
                .instanceState(instance.getState().getName())
                .ipAddress(instance.getPublicIpAddress());
    }
}
