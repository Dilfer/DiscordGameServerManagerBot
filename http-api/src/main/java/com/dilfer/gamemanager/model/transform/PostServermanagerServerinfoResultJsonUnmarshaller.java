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
 * PostServermanagerServerinfoResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerServerinfoResultJsonUnmarshaller implements Unmarshaller<PostServermanagerServerinfoResult, JsonUnmarshallerContext> {

    public PostServermanagerServerinfoResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerServerinfoResult postServermanagerServerinfoResult = new PostServermanagerServerinfoResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerServerinfoResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerServerinfoResult.setServerInfoResponse(ServerInfoResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerServerinfoResult;
    }

    private static PostServermanagerServerinfoResultJsonUnmarshaller instance;

    public static PostServermanagerServerinfoResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerServerinfoResultJsonUnmarshaller();
        return instance;
    }
}
