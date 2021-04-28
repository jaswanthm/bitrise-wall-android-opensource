
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommitPath implements Parcelable
{

    @SerializedName("added")
    @Expose
    private List<String> added = null;
    @SerializedName("removed")
    @Expose
    private List<Object> removed = null;
    @SerializedName("modified")
    @Expose
    private List<String> modified = null;
    public final static Creator<CommitPath> CREATOR = new Creator<CommitPath>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CommitPath createFromParcel(Parcel in) {
            return new CommitPath(in);
        }

        public CommitPath[] newArray(int size) {
            return (new CommitPath[size]);
        }

    }
    ;

    protected CommitPath(Parcel in) {
        in.readList(this.added, (String.class.getClassLoader()));
        in.readList(this.removed, (Object.class.getClassLoader()));
        in.readList(this.modified, (String.class.getClassLoader()));
    }

    public CommitPath() {
    }

    public List<String> getAdded() {
        return added;
    }

    public void setAdded(List<String> added) {
        this.added = added;
    }

    public List<Object> getRemoved() {
        return removed;
    }

    public void setRemoved(List<Object> removed) {
        this.removed = removed;
    }

    public List<String> getModified() {
        return modified;
    }

    public void setModified(List<String> modified) {
        this.modified = modified;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(added);
        dest.writeList(removed);
        dest.writeList(modified);
    }

    public int describeContents() {
        return  0;
    }

}
