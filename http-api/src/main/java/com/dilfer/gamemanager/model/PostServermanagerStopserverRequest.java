/**
 * null
 */
package com.dilfer.gamemanager.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerStopserver"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStopserverRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private StopServerRequest stopServerRequest;

    /**
     * @param stopServerRequest
     */

    public void setStopServerRequest(StopServerRequest stopServerRequest) {
        this.stopServerRequest = stopServerRequest;
    }

    /**
     * @return
     */

    public StopServerRequest getStopServerRequest() {
        return this.stopServerRequest;
    }

    /**
     * @param stopServerRequest
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostServermanagerStopserverRequest stopServerRequest(StopServerRequest stopServerRequest) {
        setStopServerRequest(stopServerRequest);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getStopServerRequest() != null)
            sb.append("StopServerRequest: ").append(getStopServerRequest());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostServermanagerStopserverRequest == false)
            return false;
        PostServermanagerStopserverRequest other = (PostServermanagerStopserverRequest) obj;
        if (other.getStopServerRequest() == null ^ this.getStopServerRequest() == null)
            return false;
        if (other.getStopServerRequest() != null && other.getStopServerRequest().equals(this.getStopServerRequest()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getStopServerRequest() == null) ? 0 : getStopServerRequest().hashCode());
        return hashCode;
    }

    @Override
    public PostServermanagerStopserverRequest clone() {
        return (PostServermanagerStopserverRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostServermanagerStopserverRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
