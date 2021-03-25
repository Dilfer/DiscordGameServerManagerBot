/**
 * null
 */
package com.dilfer.gamemanager.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerServerinfo"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerServerinfoRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private ServerInfoRequest serverInfoRequest;

    /**
     * @param serverInfoRequest
     */

    public void setServerInfoRequest(ServerInfoRequest serverInfoRequest) {
        this.serverInfoRequest = serverInfoRequest;
    }

    /**
     * @return
     */

    public ServerInfoRequest getServerInfoRequest() {
        return this.serverInfoRequest;
    }

    /**
     * @param serverInfoRequest
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostServermanagerServerinfoRequest serverInfoRequest(ServerInfoRequest serverInfoRequest) {
        setServerInfoRequest(serverInfoRequest);
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
        if (getServerInfoRequest() != null)
            sb.append("ServerInfoRequest: ").append(getServerInfoRequest());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostServermanagerServerinfoRequest == false)
            return false;
        PostServermanagerServerinfoRequest other = (PostServermanagerServerinfoRequest) obj;
        if (other.getServerInfoRequest() == null ^ this.getServerInfoRequest() == null)
            return false;
        if (other.getServerInfoRequest() != null && other.getServerInfoRequest().equals(this.getServerInfoRequest()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getServerInfoRequest() == null) ? 0 : getServerInfoRequest().hashCode());
        return hashCode;
    }

    @Override
    public PostServermanagerServerinfoRequest clone() {
        return (PostServermanagerServerinfoRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostServermanagerServerinfoRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
