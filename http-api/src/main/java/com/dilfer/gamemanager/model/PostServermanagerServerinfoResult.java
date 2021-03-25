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
public class PostServermanagerServerinfoResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private ServerInfoResponse serverInfoResponse;

    /**
     * @param serverInfoResponse
     */

    public void setServerInfoResponse(ServerInfoResponse serverInfoResponse) {
        this.serverInfoResponse = serverInfoResponse;
    }

    /**
     * @return
     */

    public ServerInfoResponse getServerInfoResponse() {
        return this.serverInfoResponse;
    }

    /**
     * @param serverInfoResponse
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostServermanagerServerinfoResult serverInfoResponse(ServerInfoResponse serverInfoResponse) {
        setServerInfoResponse(serverInfoResponse);
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
        if (getServerInfoResponse() != null)
            sb.append("ServerInfoResponse: ").append(getServerInfoResponse());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostServermanagerServerinfoResult == false)
            return false;
        PostServermanagerServerinfoResult other = (PostServermanagerServerinfoResult) obj;
        if (other.getServerInfoResponse() == null ^ this.getServerInfoResponse() == null)
            return false;
        if (other.getServerInfoResponse() != null && other.getServerInfoResponse().equals(this.getServerInfoResponse()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getServerInfoResponse() == null) ? 0 : getServerInfoResponse().hashCode());
        return hashCode;
    }

    @Override
    public PostServermanagerServerinfoResult clone() {
        try {
            return (PostServermanagerServerinfoResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
