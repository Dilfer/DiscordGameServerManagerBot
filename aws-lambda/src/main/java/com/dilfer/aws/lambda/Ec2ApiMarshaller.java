package com.dilfer.aws.lambda;

import com.amazonaws.services.ec2.AmazonEC2;

import java.util.List;
import java.util.function.Function;

public class Ec2ApiMarshaller
{
    private AmazonEC2 ec2;

    public Ec2ApiMarshaller(AmazonEC2 ec2)
    {
        this.ec2 = ec2;
    }

    public <T, O> O marshallRequest(Function<AmazonEC2, List<T>> ec2ApiToResultListFunction,
                                    Function<T, O> outputTransformFunction)
    {
        List<T> results = ec2ApiToResultListFunction.apply(ec2);

        if (results.isEmpty())
        {
            throw new RuntimeException("Expected a single return value from the EC2 API. " +
                    "Got none." + results.toString());
        }

        if (results.size() != 1)
        {
            throw new RuntimeException("Expected a single return value from the EC2 API. " +
                    "There should not have been multiple. \n" + results.toString());
        }

        return outputTransformFunction.apply(results.iterator().next());
    }
}
