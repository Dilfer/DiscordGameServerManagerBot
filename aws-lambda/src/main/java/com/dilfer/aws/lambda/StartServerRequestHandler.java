package com.dilfer.aws.lambda;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.util.json.Jackson;
import com.dilfer.gamemanager.model.StartServerRequest;
import com.dilfer.gamemanager.model.StartServerResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StartServerRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
{
    private final Ec2ApiMarshaller ec2ApiMarshaller;

    public StartServerRequestHandler()
    {
        this.ec2ApiMarshaller = new Ec2ApiMarshaller(AmazonEC2ClientBuilder.defaultClient());
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context)
    {
        try
        {
        context.getLogger().log(Jackson.toJsonPrettyString(input));
        StartServerRequest startServerRequest = Jackson.fromJsonString(input.getBody(), StartServerRequest.class);
        context.getLogger().log(String.format("Got a start server request for guild %s and game %s. ",
                startServerRequest.getGuild(),
                startServerRequest.getGame()));

        String instanceId = ec2ApiMarshaller.marshallRequest(ec2 -> describeInstances(ec2, startServerRequest),
                this::getInstanceId);
        StartServerResponse startServerResponse = ec2ApiMarshaller.marshallRequest(ec2 -> getInstanceStateChanges(ec2, instanceId),
                this::getResponse);

        String jsonStringResponse = Jackson.toJsonString(startServerResponse);
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

    private List<Instance> describeInstances(AmazonEC2 ec2, StartServerRequest request)
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
        StartInstancesRequest startInstancesRequest = new StartInstancesRequest()
                .withInstanceIds(instanceId);
        StartInstancesResult startInstancesResult = ec2.startInstances(startInstancesRequest);
        return startInstancesResult.getStartingInstances();
    }

    private StartServerResponse getResponse(InstanceStateChange stateChange)
    {
        return new StartServerResponse()
                .newState(stateChange.getCurrentState().getName())
                .originalState(stateChange.getPreviousState().getName());
    }
}
