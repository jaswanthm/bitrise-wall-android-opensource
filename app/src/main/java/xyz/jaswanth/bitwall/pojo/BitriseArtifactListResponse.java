
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BitriseArtifactListResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private List<BitriseArtifact> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    public final static Creator<BitriseArtifactListResponse> CREATOR = new Creator<BitriseArtifactListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BitriseArtifactListResponse createFromParcel(Parcel in) {
            return new BitriseArtifactListResponse(in);
        }

        public BitriseArtifactListResponse[] newArray(int size) {
            return (new BitriseArtifactListResponse[size]);
        }

    }
    ;

    protected BitriseArtifactListResponse(Parcel in) {
        in.readList(this.data, (BitriseArtifact.class.getClassLoader()));
        this.paging = ((Paging) in.readValue((Paging.class.getClassLoader())));
    }

    public BitriseArtifactListResponse() {
    }

    public List<BitriseArtifact> getData() {
        return data;
    }

    public void setData(List<BitriseArtifact> data) {
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
