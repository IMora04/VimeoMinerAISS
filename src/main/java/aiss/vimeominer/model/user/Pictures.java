
package aiss.vimeominer.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "base_link"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pictures {

    @JsonProperty("base_link")
    private String baseLink;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pictures() {
    }

    /**
     * 
     * @param baseLink
     */
    public Pictures(String baseLink) {
        super();
        this.baseLink = baseLink;
    }

    @JsonProperty("base_link")
    public String getBaseLink() {
        return baseLink;
    }

    @JsonProperty("base_link")
    public void setBaseLink(String baseLink) {
        this.baseLink = baseLink;
    }

    public Pictures withBaseLink(String baseLink) {
        this.baseLink = baseLink;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pictures.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("baseLink");
        sb.append('=');
        sb.append(((this.baseLink == null)?"<null>":this.baseLink));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
