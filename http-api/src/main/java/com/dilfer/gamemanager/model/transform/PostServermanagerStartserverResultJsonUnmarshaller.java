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
 * PostServermanagerStartserverResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStartserverResultJsonUnmarshaller implements Unmarshaller<PostServermanagerStartserverResult, JsonUnmarshallerContext> {

    public PostServermanagerStartserverResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerStartserverResult postServermanagerStartserverResult = new PostServermanagerStartserverResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerStartserverResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerStartserverResult.setStartServerResponse(StartServerResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerStartserverResult;
    }

    private static PostServermanagerStartserverResultJsonUnmarshaller instance;

    public static PostServermanagerStartserverResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerStartserverResultJsonUnmarshaller();
        return instance;
    }
}
