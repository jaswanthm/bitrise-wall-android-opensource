
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BitriseBuildListResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private List<BitriseBuild> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    public final static Creator<BitriseBuildListResponse> CREATOR = new Creator<BitriseBuildListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BitriseBuildListResponse createFromParcel(Parcel in) {
            return new BitriseBuildListResponse(in);
        }

        public BitriseBuildListResponse[] newArray(int size) {
            return (new BitriseBuildListResponse[size]);
        }

    }
    ;

    protected BitriseBuildListResponse(Parcel in) {
        in.readList(this.data, (BitriseBuild.class.getClassLoader()));
        this.paging = ((Paging) in.readValue((Paging.class.getClassLoader())));
    }

    public BitriseBuildListResponse() {
    }

    public List<BitriseBuild> getData() {
        return data;
    }

    public void setData(List<BitriseBuild> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(paging);
    }

    public int describeContents() {
        return  0;
    }

}
