
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitriseArtifact implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("artifact_type")
    @Expose
    private String artifactType;
    @SerializedName("artifact_meta")
    @Expose
    private Object artifactMeta;
    @SerializedName("is_public_page_enabled")
    @Expose
    private Boolean isPublicPageEnabled;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("file_size_bytes")
    @Expose
    private Integer fileSizeBytes;
    public final static Creator<BitriseArtifact> CREATOR = new Creator<BitriseArtifact>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BitriseArtifact createFromParcel(Parcel in) {
            return new BitriseArtifact(in);
        }

        public BitriseArtifact[] newArray(int size) {
            return (new BitriseArtifact[size]);
        }

    }
    ;

    protected BitriseArtifact(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.artifactType = ((String) in.readValue((String.class.getClassLoader())));
        this.artifactMeta = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isPublicPageEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.fileSizeBytes = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public BitriseArtifact() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(String artifactType) {
        this.artifactType = artifactType;
    }

    public Object getArtifactMeta() {
        return artifactMeta;
    }

    public void setArtifactMeta(Object artifactMeta) {
        this.artifactMeta = artifactMeta;
    }

    public Boolean getIsPublicPageEnabled() {
        return isPublicPageEnabled;
    }

    public void setIsPublicPageEnabled(Boolean isPublicPageEnabled) {
        this.isPublicPageEnabled = isPublicPageEnabled;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(Integer fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(artifactType);
        dest.writeValue(artifactMeta);
        dest.writeValue(isPublicPageEnabled);
        dest.writeValue(slug);
        dest.writeValue(fileSizeBytes);
    }

    public int describeContents() {
        return  0;
    }

}
