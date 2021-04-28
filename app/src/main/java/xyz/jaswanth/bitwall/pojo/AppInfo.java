
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppInfo implements Parcelable
{

    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("package_name")
    @Expose
    private String packageName;
    @SerializedName("version_code")
    @Expose
    private String versionCode;
    @SerializedName("version_name")
    @Expose
    private String versionName;
    @SerializedName("min_sdk_version")
    @Expose
    private String minSdkVersion;
    public final static Creator<AppInfo> CREATOR = new Creator<AppInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AppInfo createFromParcel(Parcel in) {
            return new AppInfo(in);
        }

        public AppInfo[] newArray(int size) {
            return (new AppInfo[size]);
        }

    }
    ;

    protected AppInfo(Parcel in) {
        this.appName = ((String) in.readValue((String.class.getClassLoader())));
        this.packageName = ((String) in.readValue((String.class.getClassLoader())));
        this.versionCode = ((String) in.readValue((String.class.getClassLoader())));
        this.versionName = ((String) in.readValue((String.class.getClassLoader())));
        this.minSdkVersion = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AppInfo() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getMinSdkVersion() {
        return minSdkVersion;
    }

    public void setMinSdkVersion(String minSdkVersion) {
        this.minSdkVersion = minSdkVersion;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(appName);
        dest.writeValue(packageName);
        dest.writeValue(versionCode);
        dest.writeValue(versionName);
        dest.writeValue(minSdkVersion);
    }

    public int describeContents() {
        return  0;
    }

}
