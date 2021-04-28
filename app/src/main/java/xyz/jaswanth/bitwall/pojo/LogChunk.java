
package xyz.jaswanth.bitwall.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogChunk implements Serializable, Parcelable
{

    @SerializedName("chunk")
    @Expose
    private String chunk;
    @SerializedName("position")
    @Expose
    private int position;
    public final static Parcelable.Creator<LogChunk> CREATOR = new Creator<LogChunk>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LogChunk createFromParcel(Parcel in) {
            return new LogChunk(in);
        }

        public LogChunk[] newArray(int size) {
            return (new LogChunk[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8456916580614989140L;

    protected LogChunk(Parcel in) {
        this.chunk = ((String) in.readValue((String.class.getClassLoader())));
        this.position = ((int) in.readValue((int.class.getClassLoader())));
    }

    public LogChunk() {
    }

    public String getChunk() {
        return chunk;
    }

    public void setChunk(String chunk) {
        this.chunk = chunk;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(chunk);
        dest.writeValue(position);
    }

    public int describeContents() {
        return  0;
    }

}
