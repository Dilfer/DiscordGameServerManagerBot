/**
 * null
 */
package com.dilfer.gamemanager.model.transform;

import java.math.*;

import javax.annotation.Generated;

import com.dilfer.gamemanager.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * PostServermanagerStopserverResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStopserverResultJsonUnmarshaller implements Unmarshaller<PostServermanagerStopserverResult, JsonUnmarshallerContext> {

    public PostServermanagerStopserverResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerStopserverResult postServermanagerStopserverResult = new PostServermanagerStopserverResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerStopserverResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerStopserverResult.setStopServerResponse(StopServerResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerStopserverResult;
    }

    private static PostServermanagerStopserverResultJsonUnmarshaller instance;

    public static PostServermanagerStopserverResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerStopserverResultJsonUnmarshaller();
        return instance;
    }
}
