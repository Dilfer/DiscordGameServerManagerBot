/**
 * null
 */
package com.dilfer.gamemanager;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import com.dilfer.gamemanager.model.*;

/**
 * Interface for accessing GameManager.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface GameManager {

    /**
     * @param postServermanagerListgamesRequest
     * @return Result of the PostServermanagerListgames operation returned by the service.
     * @sample GameManager.PostServermanagerListgames
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerListgames"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerListgamesResult postServermanagerListgames(PostServermanagerListgamesRequest postServermanagerListgamesRequest);

    /**
     * @param postServermanagerServerinfoRequest
     * @return Result of the PostServermanagerServerinfo operation returned by the service.
     * @sample GameManager.PostServermanagerServerinfo
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerServerinfo"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerServerinfoResult postServermanagerServerinfo(PostServermanagerServerinfoRequest postServermanagerServerinfoRequest);

    /**
     * @param postServermanagerStartserverRequest
     * @return Result of the PostServermanagerStartserver operation returned by the service.
     * @sample GameManager.PostServermanagerStartserver
     * @see <a
     *      href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerStartserver"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerStartserverResult postServermanagerStartserver(PostServermanagerStartserverRequest postServermanagerStartserverRequest);

    /**
     * @param postServermanagerStopserverRequest
     * @return Result of the PostServermanagerStopserver operation returned by the service.
     * @sample GameManager.PostServermanagerStopserver
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerStopserver"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerStopserverResult postServermanagerStopserver(PostServermanagerStopserverRequest postServermanagerStopserverRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static GameManagerClientBuilder builder() {
        return new GameManagerClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
