package com.dilfer.aws.lambda;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.util.json.Jackson;
import com.dilfer.gamemanager.model.StopServerRequest;
import com.dilfer.gamemanager.model.StopServerResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StopServerRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
{
    private final Ec2ApiMarshaller ec2ApiMarshaller;

    public StopServerRequestHandler()
    {
        this.ec2ApiMarshaller = new Ec2ApiMarshaller(AmazonEC2ClientBuilder.defaultClient());
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context)
    {
        try
        {
            context.getLogger().log(Jackson.toJsonPrettyString(input));
            StopServerRequest stopServerRequest = Jackson.fromJsonString(input.getBody(), StopServerRequest.class);
            context.getLogger().log(String.format("Got a stop server request for guild %s and game %s. ",
                    stopServerRequest.getGuild(),
                    stopServerRequest.getGame()));

            String instanceId = ec2ApiMarshaller.marshallRequest(ec2 -> describeInstances(ec2, stopServerRequest),
                    this::getInstanceId);
            StopServerResponse stopServerResponse = ec2ApiMarshaller.marshallRequest(ec2 -> getInstanceStateChanges(ec2, instanceId),
                    this::getResponse);

            String jsonStringResponse = Jackson.toJsonString(stopServerResponse);
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

    private List<Instance> describeInstances(AmazonEC2 ec2, StopServerRequest request)
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

    private String getInstanceId(Instance instance)
    {
        return instance.getInstanceId();
    }

    private List<InstanceStateChange> getInstanceStateChanges(AmazonEC2 ec2, String instanceId)
    {
        StopInstancesRequest stopInstancesRequest = new StopInstancesRequest()
                .withInstanceIds(instanceId);
        StopInstancesResult stopInstancesResponse = ec2.stopInstances(stopInstancesRequest);
        return stopInstancesResponse.getStoppingInstances();
    }

    private StopServerResponse getResponse(InstanceStateChange stateChange)
    {
        return new StopServerResponse()
                .newState(stateChange.getCurrentState().getName())
                .originalState(stateChange.getPreviousState().getName());
    }
}
