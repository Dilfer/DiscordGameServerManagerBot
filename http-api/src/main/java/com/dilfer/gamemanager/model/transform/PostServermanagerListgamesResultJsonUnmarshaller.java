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
 * PostServermanagerListgamesResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerListgamesResultJsonUnmarshaller implements Unmarshaller<PostServermanagerListgamesResult, JsonUnmarshallerContext> {

    public PostServermanagerListgamesResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerListgamesResult postServermanagerListgamesResult = new PostServermanagerListgamesResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerListgamesResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerListgamesResult.setListGamesResponse(ListGamesResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerListgamesResult;
    }

    private static PostServermanagerListgamesResultJsonUnmarshaller instance;

    public static PostServermanagerListgamesResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerListgamesResultJsonUnmarshaller();
        return instance;
    }
}
