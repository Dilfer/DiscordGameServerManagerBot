/**
 * null
 */
package com.dilfer.gamemanager;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.opensdk.protect.client.SdkSyncClientBuilder;
import com.amazonaws.opensdk.internal.config.ApiGatewayClientConfigurationFactory;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.Protocol;

import java.net.URI;
import javax.annotation.Generated;

/**
 * Fluent builder for {@link GameManager}.
 * 
 * @see GameManager#builder
 **/
@NotThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public final class GameManagerClientBuilder extends SdkSyncClientBuilder<GameManagerClientBuilder, GameManager> {

    private static final URI DEFAULT_ENDPOINT = RuntimeHttpUtils.toUri("2dbnwftaad.execute-api.ca-central-1.amazonaws.com", Protocol.HTTPS);
    private static final String DEFAULT_REGION = "ca-central-1";

    /**
     * Package private constructor - builder should be created via {@link GameManager#builder()}
     */
    GameManagerClientBuilder() {
        super(new ApiGatewayClientConfigurationFactory());
    }

    /**
     * Specify the API Key to send with requests.
     *
     * @param apiKey
     *        API Key that identifies caller.
     * @return This object for method chaining.
     */
    @Override
    public void setApiKey(String apiKey) {
        super.setApiKey(apiKey);
    }

    /**
     * Specify the API Key to send with requests.
     *
     * @param apiKey
     *        API Key that identifies caller.
     * @return This object for method chaining.
     */
    public GameManagerClientBuilder apiKey(String apiKey) {
        setApiKey(apiKey);
        return this;
    }

    /**
     * Construct a synchronous implementation of GameManager using the current builder configuration.
     *
     * @param params
     *        Current builder configuration represented as a parameter object.
     * @return Fully configured implementation of GameManager.
     */
    @Override
    protected GameManager build(AwsSyncClientParams params) {
        return new GameManagerClient(params);
    }

    @Override
    protected URI defaultEndpoint() {
        return DEFAULT_ENDPOINT;
    }

    @Override
    protected String defaultRegion() {
        return DEFAULT_REGION;
    }

}
