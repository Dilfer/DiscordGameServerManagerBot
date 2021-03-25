/**
 * null
 */
package com.dilfer.gamemanager.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;

import com.amazonaws.http.HttpMethodName;
import com.dilfer.gamemanager.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.*;
import com.amazonaws.protocol.Protocol;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * PostServermanagerStopserverRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostServermanagerStopserverRequestProtocolMarshaller implements
        Marshaller<Request<PostServermanagerStopserverRequest>, PostServermanagerStopserverRequest> {

    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.API_GATEWAY)
            .requestUri("/prod/servermanager/stopserver").httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(true).hasPayloadMembers(true)
            .serviceName("GameManager").build();

    private final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory;

    public PostServermanagerStopserverRequestProtocolMarshaller(com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<PostServermanagerStopserverRequest> marshall(PostServermanagerStopserverRequest postServermanagerStopserverRequest) {

        if (postServermanagerStopserverRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            final ProtocolRequestMarshaller<PostServermanagerStopserverRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(
                    SDK_OPERATION_BINDING, postServermanagerStopserverRequest);

            protocolMarshaller.startMarshalling();
            PostServermanagerStopserverRequestMarshaller.getInstance().marshall(postServermanagerStopserverRequest, protocolMarshaller);
            return protocolMarshaller.finishMarshalling();
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
