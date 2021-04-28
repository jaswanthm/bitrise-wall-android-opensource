
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitriseArtifactDetailResponse implements Parcelable
{

    @SerializedName("data")
    @Expose
    private Data data;
    public final static Creator<BitriseArtifactDetailResponse> CREATOR = new Creator<BitriseArtifactDetailResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BitriseArtifactDetailResponse createFromParcel(Parcel in) {
            return new BitriseArtifactDetailResponse(in);
        }

        public BitriseArtifactDetailResponse[] newArray(int size) {
            return (new BitriseArtifactDetailResponse[size]);
        }

    }
    ;

    protected BitriseArtifactDetailResponse(Parcel in) {
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public BitriseArtifactDetailResponse() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
