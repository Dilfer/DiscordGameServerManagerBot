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
 * ListGamesResponse JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ListGamesResponseJsonUnmarshaller implements Unmarshaller<ListGamesResponse, JsonUnmarshallerContext> {

    public ListGamesResponse unmarshall(JsonUnmarshallerContext context) throws Exception {
        ListGamesResponse listGamesResponse = new ListGamesResponse();

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
                if (context.testExpression("games", targetDepth)) {
                    context.nextToken();
                    listGamesResponse.setGames(new ListUnmarshaller<String>(context.getUnmarshaller(String.class)).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return listGamesResponse;
    }

    private static ListGamesResponseJsonUnmarshaller instance;

    public static ListGamesResponseJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListGamesResponseJsonUnmarshaller();
        return instance;
    }
}
