/**
 * null
 */
package com.dilfer.gamemanager.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.dilfer.gamemanager.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * PostServermanagerStartserverRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostServermanagerStartserverRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> STARTSERVERREQUEST_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostServermanagerStartserverRequestMarshaller instance = new PostServermanagerStartserverRequestMarshaller();

    public static PostServermanagerStartserverRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostServermanagerStartserverRequest postServermanagerStartserverRequest, ProtocolMarshaller protocolMarshaller) {

        if (postServermanagerStartserverRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postServermanagerStartserverRequest.getStartServerRequest(), STARTSERVERREQUEST_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
