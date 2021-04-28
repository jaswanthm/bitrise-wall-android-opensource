
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("artifact_type")
    @Expose
    private String artifactType;
    @SerializedName("artifact_meta")
    @Expose
    private ArtifactMeta artifactMeta;
    @SerializedName("expiring_download_url")
    @Expose
    private String expiringDownloadUrl;
    @SerializedName("is_public_page_enabled")
    @Expose
    private Boolean isPublicPageEnabled;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("public_install_page_url")
    @Expose
    private String publicInstallPageUrl;
    @SerializedName("file_size_bytes")
    @Expose
    private Integer fileSizeBytes;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;

    protected Data(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.artifactType = ((String) in.readValue((String.class.getClassLoader())));
        this.artifactMeta = ((ArtifactMeta) in.readValue((ArtifactMeta.class.getClassLoader())));
        this.expiringDownloadUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.isPublicPageEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.publicInstallPageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.fileSizeBytes = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Data() {
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

    public ArtifactMeta getArtifactMeta() {
        return artifactMeta;
    }

    public void setArtifactMeta(ArtifactMeta artifactMeta) {
        this.artifactMeta = artifactMeta;
    }

    public String getExpiringDownloadUrl() {
        return expiringDownloadUrl;
    }

    public void setExpiringDownloadUrl(String expiringDownloadUrl) {
        this.expiringDownloadUrl = expiringDownloadUrl;
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

    public String getPublicInstallPageUrl() {
        return publicInstallPageUrl;
    }

    public void setPublicInstallPageUrl(String publicInstallPageUrl) {
        this.publicInstallPageUrl = publicInstallPageUrl;
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
        dest.writeValue(expiringDownloadUrl);
        dest.writeValue(isPublicPageEnabled);
        dest.writeValue(slug);
        dest.writeValue(publicInstallPageUrl);
        dest.writeValue(fileSizeBytes);
    }

    public int describeContents() {
        return  0;
    }

}
