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
 * ListGamesRequest JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ListGamesRequestJsonUnmarshaller implements Unmarshaller<ListGamesRequest, JsonUnmarshallerContext> {

    public ListGamesRequest unmarshall(JsonUnmarshallerContext context) throws Exception {
        ListGamesRequest listGamesRequest = new ListGamesRequest();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("guild", targetDepth)) {
                    context.nextToken();
                    listGamesRequest.setGuild(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return listGamesRequest;
    }

    private static ListGamesRequestJsonUnmarshaller instance;

    public static ListGamesRequestJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListGamesRequestJsonUnmarshaller();
        return instance;
    }
}