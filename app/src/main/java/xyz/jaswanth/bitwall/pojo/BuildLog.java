
package xyz.jaswanth.bitwall.pojo;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuildLog implements Serializable, Parcelable
{

    @SerializedName("expiring_raw_log_url")
    @Expose
    private String expiringRawLogUrl;
    @SerializedName("generated_log_chunks_num")
    @Expose
    private int generatedLogChunksNum;
    @SerializedName("is_archived")
    @Expose
    private boolean isArchived;
    @SerializedName("log_chunks")
    @Expose
    private List<LogChunk> logChunks = null;
    @SerializedName("timestamp")
    @Expose
    private Object timestamp;
    public final static Parcelable.Creator<BuildLog> CREATOR = new Creator<BuildLog>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BuildLog createFromParcel(Parcel in) {
            return new BuildLog(in);
        }

        public BuildLog[] newArray(int size) {
            return (new BuildLog[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2132897660335850980L;

    protected BuildLog(Parcel in) {
        this.expiringRawLogUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.generatedLogChunksNum = ((int) in.readValue((int.class.getClassLoader())));
        this.isArchived = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.logChunks, (xyz.jaswanth.bitwall.pojo.LogChunk.class.getClassLoader()));
        this.timestamp = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public BuildLog() {
    }

    public String getExpiringRawLogUrl() {
        return expiringRawLogUrl;
    }

    public void setExpiringRawLogUrl(String expiringRawLogUrl) {
        this.expiringRawLogUrl = expiringRawLogUrl;
    }

    public int getGeneratedLogChunksNum() {
        return generatedLogChunksNum;
    }

    public void setGeneratedLogChunksNum(int generatedLogChunksNum) {
        this.generatedLogChunksNum = generatedLogChunksNum;
    }

    public boolean isIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public List<LogChunk> getLogChunks() {
        return logChunks;
    }

    public void setLogChunks(List<LogChunk> logChunks) {
        this.logChunks = logChunks;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(expiringRawLogUrl);
        dest.writeValue(generatedLogChunksNum);
        dest.writeValue(isArchived);
        dest.writeList(logChunks);
        dest.writeValue(timestamp);
    }

    public int describeContents() {
        return  0;
    }

}
