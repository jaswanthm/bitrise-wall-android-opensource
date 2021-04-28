
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("project_type")
    @Expose
    private String projectType;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("repo_owner")
    @Expose
    private String repoOwner;
    @SerializedName("repo_url")
    @Expose
    private String repoUrl;
    @SerializedName("repo_slug")
    @Expose
    private String repoSlug;
    @SerializedName("is_disabled")
    @Expose
    private Boolean isDisabled;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("is_public")
    @Expose
    private Boolean isPublic;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    protected Datum(Parcel in) {
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.projectType = ((String) in.readValue((String.class.getClassLoader())));
        this.provider = ((String) in.readValue((String.class.getClassLoader())));
        this.repoOwner = ((String) in.readValue((String.class.getClassLoader())));
        this.repoUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.repoSlug = ((String) in.readValue((String.class.getClassLoader())));
        this.isDisabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isPublic = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.owner = ((Owner) in.readValue((Owner.class.getClassLoader())));
        this.avatarUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRepoOwner() {
        return repoOwner;
    }

    public void setRepoOwner(String repoOwner) {
        this.repoOwner = repoOwner;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public String getRepoSlug() {
        return repoSlug;
    }

    public void setRepoSlug(String repoSlug) {
        this.repoSlug = repoSlug;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slug);
        dest.writeValue(title);
        dest.writeValue(projectType);
        dest.writeValue(provider);
        dest.writeValue(repoOwner);
        dest.writeValue(repoUrl);
        dest.writeValue(repoSlug);
        dest.writeValue(isDisabled);
        dest.writeValue(status);
        dest.writeValue(isPublic);
        dest.writeValue(owner);
        dest.writeValue(avatarUrl);
    }

    public int describeContents() {
        return  0;
    }

}
