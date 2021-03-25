/**
 * null
 */
package com.dilfer.gamemanager.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/2dbnwftaad-2021-03-25T18:44:59Z/PostServermanagerStartserver"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStartserverResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private StartServerResponse startServerResponse;

    /**
     * @param startServerResponse
     */

    public void setStartServerResponse(StartServerResponse startServerResponse) {
        this.startServerResponse = startServerResponse;
    }

    /**
     * @return
     */

    public StartServerResponse getStartServerResponse() {
        return this.startServerResponse;
    }

    /**
     * @param startServerResponse
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostServermanagerStartserverResult startServerResponse(StartServerResponse startServerResponse) {
        setStartServerResponse(startServerResponse);
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
        if (getStartServerResponse() != null)
            sb.append("StartServerResponse: ").append(getStartServerResponse());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostServermanagerStartserverResult == false)
            return false;
        PostServermanagerStartserverResult other = (PostServermanagerStartserverResult) obj;
        if (other.getStartServerResponse() == null ^ this.getStartServerResponse() == null)
            return false;
        if (other.getStartServerResponse() != null && other.getStartServerResponse().equals(this.getStartServerResponse()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getStartServerResponse() == null) ? 0 : getStartServerResponse().hashCode());
        return hashCode;
    }

    @Override
    public PostServermanagerStartserverResult clone() {
        try {
            return (PostServermanagerStartserverResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
