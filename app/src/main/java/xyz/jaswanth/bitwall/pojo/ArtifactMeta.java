
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtifactMeta implements Parcelable
{

    @SerializedName("info_type_id")
    @Expose
    private String infoTypeId;
    @SerializedName("file_size_bytes")
    @Expose
    private String fileSizeBytes;
    @SerializedName("module")
    @Expose
    private Object module;
    @SerializedName("product_flavour")
    @Expose
    private Object productFlavour;
    @SerializedName("build_type")
    @Expose
    private Object buildType;
    @SerializedName("include")
    @Expose
    private Object include;
    @SerializedName("universal")
    @Expose
    private Object universal;
    @SerializedName("aab")
    @Expose
    private Object aab;
    @SerializedName("apk")
    @Expose
    private Object apk;
    @SerializedName("split")
    @Expose
    private Object split;
    @SerializedName("app_info")
    @Expose
    private AppInfo appInfo;
    public final static Creator<ArtifactMeta> CREATOR = new Creator<ArtifactMeta>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ArtifactMeta createFromParcel(Parcel in) {
            return new ArtifactMeta(in);
        }

        public ArtifactMeta[] newArray(int size) {
            return (new ArtifactMeta[size]);
        }

    }
    ;

    protected ArtifactMeta(Parcel in) {
        this.infoTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.fileSizeBytes = ((String) in.readValue((String.class.getClassLoader())));
        this.module = ((Object) in.readValue((Object.class.getClassLoader())));
        this.productFlavour = ((Object) in.readValue((Object.class.getClassLoader())));
        this.buildType = ((Object) in.readValue((Object.class.getClassLoader())));
        this.include = ((Object) in.readValue((Object.class.getClassLoader())));
        this.universal = ((Object) in.readValue((Object.class.getClassLoader())));
        this.aab = ((Object) in.readValue((Object.class.getClassLoader())));
        this.apk = ((Object) in.readValue((Object.class.getClassLoader())));
        this.split = ((Object) in.readValue((Object.class.getClassLoader())));
        this.appInfo = ((AppInfo) in.readValue((AppInfo.class.getClassLoader())));
    }

    public ArtifactMeta() {
    }

    public String getInfoTypeId() {
        return infoTypeId;
    }

    public void setInfoTypeId(String infoTypeId) {
        this.infoTypeId = infoTypeId;
    }

    public String getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(String fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public Object getModule() {
        return module;
    }

    public void setModule(Object module) {
        this.module = module;
    }

    public Object getProductFlavour() {
        return productFlavour;
    }

    public void setProductFlavour(Object productFlavour) {
        this.productFlavour = productFlavour;
    }

    public Object getBuildType() {
        return buildType;
    }

    public void setBuildType(Object buildType) {
        this.buildType = buildType;
    }

    public Object getInclude() {
        return include;
    }

    public void setInclude(Object include) {
        this.include = include;
    }

    public Object getUniversal() {
        return universal;
    }

    public void setUniversal(Object universal) {
        this.universal = universal;
    }

    public Object getAab() {
        return aab;
    }

    public void setAab(Object aab) {
        this.aab = aab;
    }

    public Object getApk() {
        return apk;
    }

    public void setApk(Object apk) {
        this.apk = apk;
    }

    public Object getSplit() {
        return split;
    }

    public void setSplit(Object split) {
        this.split = split;
    }

    public AppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(infoTypeId);
        dest.writeValue(fileSizeBytes);
        dest.writeValue(module);
        dest.writeValue(productFlavour);
        dest.writeValue(buildType);
        dest.writeValue(include);
        dest.writeValue(universal);
        dest.writeValue(aab);
        dest.writeValue(apk);
        dest.writeValue(split);
        dest.writeValue(appInfo);
    }

    public int describeContents() {
        return  0;
    }

}
