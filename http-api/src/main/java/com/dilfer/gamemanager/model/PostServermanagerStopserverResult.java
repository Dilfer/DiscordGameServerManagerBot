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
public class PostServermanagerStopserverResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private StopServerResponse stopServerResponse;

    /**
     * @param stopServerResponse
     */

    public void setStopServerResponse(StopServerResponse stopServerResponse) {
        this.stopServerResponse = stopServerResponse;
    }

    /**
     * @return
     */

    public StopServerResponse getStopServerResponse() {
        return this.stopServerResponse;
    }

    /**
     * @param stopServerResponse
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostServermanagerStopserverResult stopServerResponse(StopServerResponse stopServerResponse) {
        setStopServerResponse(stopServerResponse);
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
        if (getStopServerResponse() != null)
            sb.append("StopServerResponse: ").append(getStopServerResponse());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostServermanagerStopserverResult == false)
            return false;
        PostServermanagerStopserverResult other = (PostServermanagerStopserverResult) obj;
        if (other.getStopServerResponse() == null ^ this.getStopServerResponse() == null)
            return false;
        if (other.getStopServerResponse() != null && other.getStopServerResponse().equals(this.getStopServerResponse()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getStopServerResponse() == null) ? 0 : getStopServerResponse().hashCode());
        return hashCode;
    }

    @Override
    public PostServermanagerStopserverResult clone() {
        try {
            return (PostServermanagerStopserverResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
