
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BitriseAppListResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    public final static Creator<BitriseAppListResponse> CREATOR = new Creator<BitriseAppListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BitriseAppListResponse createFromParcel(Parcel in) {
            return new BitriseAppListResponse(in);
        }

        public BitriseAppListResponse[] newArray(int size) {
            return (new BitriseAppListResponse[size]);
        }

    }
    ;

    protected BitriseAppListResponse(Parcel in) {
        in.readList(this.data, (Datum.class.getClassLoader()));
        this.paging = ((Paging) in.readValue((Paging.class.getClassLoader())));
    }

    public BitriseAppListResponse() {
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
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
