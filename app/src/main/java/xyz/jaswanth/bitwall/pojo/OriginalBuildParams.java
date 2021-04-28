
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OriginalBuildParams implements Parcelable
{

    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("commit_hash")
    @Expose
    private String commitHash;
    @SerializedName("commit_message")
    @Expose
    private String commitMessage;
    @SerializedName("diff_url")
    @Expose
    private String diffUrl;
    @SerializedName("commit_paths")
    @Expose
    private List<CommitPath> commitPaths = null;
    @SerializedName("workflow_id")
    @Expose
    private String workflowId;
    public final static Creator<OriginalBuildParams> CREATOR = new Creator<OriginalBuildParams>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OriginalBuildParams createFromParcel(Parcel in) {
            return new OriginalBuildParams(in);
        }

        public OriginalBuildParams[] newArray(int size) {
            return (new OriginalBuildParams[size]);
        }

    }
    ;

    protected OriginalBuildParams(Parcel in) {
        this.branch = ((String) in.readValue((String.class.getClassLoader())));
        this.commitHash = ((String) in.readValue((String.class.getClassLoader())));
        this.commitMessage = ((String) in.readValue((String.class.getClassLoader())));
        this.diffUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.commitPaths, (CommitPath.class.getClassLoader()));
        this.workflowId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OriginalBuildParams() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    public String getDiffUrl() {
        return diffUrl;
    }

    public void setDiffUrl(String diffUrl) {
        this.diffUrl = diffUrl;
    }

    public List<CommitPath> getCommitPaths() {
        return commitPaths;
    }

    public void setCommitPaths(List<CommitPath> commitPaths) {
        this.commitPaths = commitPaths;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(branch);
        dest.writeValue(commitHash);
        dest.writeValue(commitMessage);
        dest.writeValue(diffUrl);
        dest.writeList(commitPaths);
        dest.writeValue(workflowId);
    }

    public int describeContents() {
        return  0;
    }

}
