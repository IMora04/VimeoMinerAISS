
package aiss.YouTubeMiner.model.youtube.comment;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentSnippet__1 {

    @JsonProperty("textOriginal")
    private String textOriginal;


    @JsonProperty("authorDisplayName")
    private String authorDisplayName;
    @JsonProperty("authorProfileImageUrl")
    private String authorProfileImageUrl;
    @JsonProperty("authorChannelUrl")
    private String authorChannelUrl;
    @JsonProperty("authorChannelId")
    private AuthorChannelId authorChannelId;
    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("textOriginal")
    public String getTextOriginal() {
        return textOriginal;
    }

    @JsonProperty("textOriginal")
    public void setTextOriginal(String textOriginal) {
        this.textOriginal = textOriginal;
    }

    @JsonProperty("authorDisplayName")
    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    @JsonProperty("authorDisplayName")
    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    @JsonProperty("authorProfileImageUrl")
    public String getAuthorProfileImageUrl() {
        return authorProfileImageUrl;
    }

    @JsonProperty("authorProfileImageUrl")
    public void setAuthorProfileImageUrl(String authorProfileImageUrl) {
        this.authorProfileImageUrl = authorProfileImageUrl;
    }

    @JsonProperty("authorChannelUrl")
    public String getAuthorChannelUrl() {
        return authorChannelUrl;
    }

    @JsonProperty("authorChannelUrl")
    public void setAuthorChannelUrl(String authorChannelUrl) {
        this.authorChannelUrl = authorChannelUrl;
    }

    @JsonProperty("authorChannelId")
    public AuthorChannelId getAuthorChannelId() {
        return authorChannelId;
    }

    @JsonProperty("authorChannelId")
    public void setAuthorChannelId(AuthorChannelId authorChannelId) {
        this.authorChannelId = authorChannelId;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommentSnippet__1.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("textOriginal");
        sb.append('=');
        sb.append(((this.textOriginal == null)?"<null>":this.textOriginal));
        sb.append(',');
        sb.append("authorDisplayName");
        sb.append('=');
        sb.append(((this.authorDisplayName == null)?"<null>":this.authorDisplayName));
        sb.append(',');
        sb.append("authorProfileImageUrl");
        sb.append('=');
        sb.append(((this.authorProfileImageUrl == null)?"<null>":this.authorProfileImageUrl));
        sb.append(',');
        sb.append("authorChannelUrl");
        sb.append('=');
        sb.append(((this.authorChannelUrl == null)?"<null>":this.authorChannelUrl));
        sb.append(',');
        sb.append("authorChannelId");
        sb.append('=');
        sb.append(((this.authorChannelId == null)?"<null>":this.authorChannelId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
