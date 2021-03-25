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
 * PostServermanagerListgamesRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostServermanagerListgamesRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> LISTGAMESREQUEST_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostServermanagerListgamesRequestMarshaller instance = new PostServermanagerListgamesRequestMarshaller();

    public static PostServermanagerListgamesRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostServermanagerListgamesRequest postServermanagerListgamesRequest, ProtocolMarshaller protocolMarshaller) {

        if (postServermanagerListgamesRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postServermanagerListgamesRequest.getListGamesRequest(), LISTGAMESREQUEST_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
