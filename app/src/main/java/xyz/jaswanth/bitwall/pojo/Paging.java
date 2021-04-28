
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging implements Parcelable
{

    @SerializedName("total_item_count")
    @Expose
    private Integer totalItemCount;
    @SerializedName("page_item_limit")
    @Expose
    private Integer pageItemLimit;
    @SerializedName("next")
    @Expose
    private String next = "";

    public final static Creator<Paging> CREATOR = new Creator<Paging>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Paging createFromParcel(Parcel in) {
            return new Paging(in);
        }

        public Paging[] newArray(int size) {
            return (new Paging[size]);
        }

    }
    ;

    protected Paging(Parcel in) {
        this.totalItemCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pageItemLimit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.next =  ((String) in.readValue((String.class.getClassLoader())));
    }

    public Paging() {
    }

    public Integer getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(Integer totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public Integer getPageItemLimit() {
        return pageItemLimit;
    }

    public void setPageItemLimit(Integer pageItemLimit) {
        this.pageItemLimit = pageItemLimit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalItemCount);
        dest.writeValue(pageItemLimit);
        dest.writeValue(next);
    }

    public int describeContents() {
        return  0;
    }
}
