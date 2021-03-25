/**
 * null
 */
package com.dilfer.gamemanager;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.opensdk.protect.model.transform.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;

import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;

import com.amazonaws.client.ClientHandler;
import com.amazonaws.client.ClientHandlerParams;
import com.amazonaws.client.ClientExecutionParams;
import com.amazonaws.opensdk.protect.client.SdkClientHandler;
import com.amazonaws.SdkBaseException;

import com.dilfer.gamemanager.model.*;
import com.dilfer.gamemanager.model.transform.*;

/**
 * Client for accessing GameManager. All service calls made using this client are blocking, and will not return until
 * the service call completes.
 * <p>
 * 
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
class GameManagerClient implements GameManager {

    private final ClientHandler clientHandler;

    private static final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory = new com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl(
            new JsonClientMetadata().withProtocolVersion("1.1").withSupportsCbor(false).withSupportsIon(false).withContentTypeOverride("application/json")
                    .withBaseServiceExceptionClass(GameManagerException.class));

    /**
     * Constructs a new client to invoke service methods on GameManager using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    GameManagerClient(AwsSyncClientParams clientParams) {
        this.clientHandler = new SdkClientHandler(new ClientHandlerParams().withClientParams(clientParams));
    }

    /**
     * @param postServermanagerListgamesRequest
     * @return Result of the PostServermanagerListgames operation returned by the service.
     * @sample GameManager.PostServermanagerListgames
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerListgames"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerListgamesResult postServermanagerListgames(PostServermanagerListgamesRequest postServermanagerListgamesRequest) {
        HttpResponseHandler<PostServermanagerListgamesResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerListgamesResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerListgamesRequest, PostServermanagerListgamesResult>()
                .withMarshaller(new PostServermanagerListgamesRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerListgamesRequest));
    }

    /**
     * @param postServermanagerServerinfoRequest
     * @return Result of the PostServermanagerServerinfo operation returned by the service.
     * @sample GameManager.PostServermanagerServerinfo
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerServerinfo"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerServerinfoResult postServermanagerServerinfo(PostServermanagerServerinfoRequest postServermanagerServerinfoRequest) {
        HttpResponseHandler<PostServermanagerServerinfoResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerServerinfoResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerServerinfoRequest, PostServermanagerServerinfoResult>()
                .withMarshaller(new PostServermanagerServerinfoRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerServerinfoRequest));
    }

    /**
     * @param postServermanagerStartserverRequest
     * @return Result of the PostServermanagerStartserver operation returned by the service.
     * @sample GameManager.PostServermanagerStartserver
     * @see <a
     *      href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerStartserver"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerStartserverResult postServermanagerStartserver(PostServermanagerStartserverRequest postServermanagerStartserverRequest) {
        HttpResponseHandler<PostServermanagerStartserverResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerStartserverResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerStartserverRequest, PostServermanagerStartserverResult>()
                .withMarshaller(new PostServermanagerStartserverRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerStartserverRequest));
    }

    /**
     * @param postServermanagerStopserverRequest
     * @return Result of the PostServermanagerStopserver operation returned by the service.
     * @sample GameManager.PostServermanagerStopserver
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerStopserver"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerStopserverResult postServermanagerStopserver(PostServermanagerStopserverRequest postServermanagerStopserverRequest) {
        HttpResponseHandler<PostServermanagerStopserverResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerStopserverResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerStopserverRequest, PostServermanagerStopserverResult>()
                .withMarshaller(new PostServermanagerStopserverRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerStopserverRequest));
    }

    /**
     * Create the error response handler for the operation.
     * 
     * @param errorShapeMetadata
     *        Error metadata for the given operation
     * @return Configured error response handler to pass to HTTP layer
     */
    private HttpResponseHandler<SdkBaseException> createErrorResponseHandler(JsonErrorShapeMetadata... errorShapeMetadata) {
        return protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata().withErrorShapes(Arrays.asList(errorShapeMetadata)));
    }

    @Override
    public void shutdown() {
        clientHandler.shutdown();
    }

}
