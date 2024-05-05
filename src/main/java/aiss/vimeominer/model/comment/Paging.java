
package aiss.vimeominer.model.comment;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "next",
    "previous",
    "first",
    "last"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {

    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private Object previous;
    @JsonProperty("first")
    private String first;
    @JsonProperty("last")
    private String last;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Paging() {
    }

    /**
     * 
     * @param next
     * @param previous
     * @param last
     * @param first
     */
    public Paging(String next, Object previous, String first, String last) {
        super();
        this.next = next;
        this.previous = previous;
        this.first = first;
        this.last = last;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    public Paging withNext(String next) {
        this.next = next;
        return this;
    }

    @JsonProperty("previous")
    public Object getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Paging withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    @JsonProperty("first")
    public String getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(String first) {
        this.first = first;
    }

    public Paging withFirst(String first) {
        this.first = first;
        return this;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    public Paging withLast(String last) {
        this.last = last;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Paging withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Paging.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("next");
        sb.append('=');
        sb.append(((this.next == null)?"<null>":this.next));
        sb.append(',');
        sb.append("previous");
        sb.append('=');
        sb.append(((this.previous == null)?"<null>":this.previous));
        sb.append(',');
        sb.append("first");
        sb.append('=');
        sb.append(((this.first == null)?"<null>":this.first));
        sb.append(',');
        sb.append("last");
        sb.append('=');
        sb.append(((this.last == null)?"<null>":this.last));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
