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
 * PostServermanagerServerinfoRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostServermanagerServerinfoRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> SERVERINFOREQUEST_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostServermanagerServerinfoRequestMarshaller instance = new PostServermanagerServerinfoRequestMarshaller();

    public static PostServermanagerServerinfoRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostServermanagerServerinfoRequest postServermanagerServerinfoRequest, ProtocolMarshaller protocolMarshaller) {

        if (postServermanagerServerinfoRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postServermanagerServerinfoRequest.getServerInfoRequest(), SERVERINFOREQUEST_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
