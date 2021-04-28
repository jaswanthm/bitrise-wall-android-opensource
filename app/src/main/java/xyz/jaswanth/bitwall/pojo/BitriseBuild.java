
package xyz.jaswanth.bitwall.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitriseBuild implements Parcelable
{

    @SerializedName("triggered_at")
    @Expose
    private String triggeredAt;
    @SerializedName("started_on_worker_at")
    @Expose
    private String startedOnWorkerAt;
    @SerializedName("environment_prepare_finished_at")
    @Expose
    private String environmentPrepareFinishedAt;
    @SerializedName("finished_at")
    @Expose
    private String finishedAt;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("abort_reason")
    @Expose
    private Object abortReason;
    @SerializedName("is_on_hold")
    @Expose
    private Boolean isOnHold;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("build_number")
    @Expose
    private Integer buildNumber;
    @SerializedName("commit_hash")
    @Expose
    private Object commitHash;
    @SerializedName("commit_message")
    @Expose
    private Object commitMessage;
    @SerializedName("tag")
    @Expose
    private Object tag;
    @SerializedName("triggered_workflow")
    @Expose
    private String triggeredWorkflow;
    @SerializedName("triggered_by")
    @Expose
    private String triggeredBy;
    @SerializedName("machine_type_id")
    @Expose
    private String machineTypeId;
    @SerializedName("stack_identifier")
    @Expose
    private String stackIdentifier;
    @SerializedName("original_build_params")
    @Expose
    private OriginalBuildParams originalBuildParams;
    @SerializedName("pull_request_id")
    @Expose
    private Integer pullRequestId;
    @SerializedName("pull_request_target_branch")
    @Expose
    private Object pullRequestTargetBranch;
    @SerializedName("pull_request_view_url")
    @Expose
    private Object pullRequestViewUrl;
    @SerializedName("commit_view_url")
    @Expose
    private Object commitViewUrl;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    protected BitriseBuild(Parcel in) {
        this.triggeredAt = ((String) in.readValue((String.class.getClassLoader())));
        this.startedOnWorkerAt = ((String) in.readValue((String.class.getClassLoader())));
        this.environmentPrepareFinishedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.finishedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusText = ((String) in.readValue((String.class.getClassLoader())));
        this.abortReason = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isOnHold = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.branch = ((String) in.readValue((String.class.getClassLoader())));
        this.buildNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.commitHash = ((Object) in.readValue((Object.class.getClassLoader())));
        this.commitMessage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.tag = ((Object) in.readValue((Object.class.getClassLoader())));
        this.triggeredWorkflow = ((String) in.readValue((String.class.getClassLoader())));
        this.triggeredBy = ((String) in.readValue((String.class.getClassLoader())));
        this.machineTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.stackIdentifier = ((String) in.readValue((String.class.getClassLoader())));
        this.originalBuildParams = ((OriginalBuildParams) in.readValue((OriginalBuildParams.class.getClassLoader())));
        this.pullRequestId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pullRequestTargetBranch = ((Object) in.readValue((Object.class.getClassLoader())));
        this.pullRequestViewUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.commitViewUrl = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public BitriseBuild() {
    }

    public String getTriggeredAt() {
        return triggeredAt;
    }

    public void setTriggeredAt(String triggeredAt) {
        this.triggeredAt = triggeredAt;
    }

    public String getStartedOnWorkerAt() {
        return startedOnWorkerAt;
    }

    public void setStartedOnWorkerAt(String startedOnWorkerAt) {
        this.startedOnWorkerAt = startedOnWorkerAt;
    }

    public String getEnvironmentPrepareFinishedAt() {
        return environmentPrepareFinishedAt;
    }

    public void setEnvironmentPrepareFinishedAt(String environmentPrepareFinishedAt) {
        this.environmentPrepareFinishedAt = environmentPrepareFinishedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Object getAbortReason() {
        return abortReason;
    }

    public void setAbortReason(Object abortReason) {
        this.abortReason = abortReason;
    }

    public Boolean getIsOnHold() {
        return isOnHold;
    }

    public void setIsOnHold(Boolean isOnHold) {
        this.isOnHold = isOnHold;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Object getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(Object commitHash) {
        this.commitHash = commitHash;
    }

    public Object getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(Object commitMessage) {
        this.commitMessage = commitMessage;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public String getTriggeredWorkflow() {
        return triggeredWorkflow;
    }

    public void setTriggeredWorkflow(String triggeredWorkflow) {
        this.triggeredWorkflow = triggeredWorkflow;
    }

    public String getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(String triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getStackIdentifier() {
        return stackIdentifier;
    }

    public void setStackIdentifier(String stackIdentifier) {
        this.stackIdentifier = stackIdentifier;
    }

    public OriginalBuildParams getOriginalBuildParams() {
        return originalBuildParams;
    }

    public void setOriginalBuildParams(OriginalBuildParams originalBuildParams) {
        this.originalBuildParams = originalBuildParams;
    }

    public Integer getPullRequestId() {
        return pullRequestId;
    }

    public void setPullRequestId(Integer pullRequestId) {
        this.pullRequestId = pullRequestId;
    }

    public Object getPullRequestTargetBranch() {
        return pullRequestTargetBranch;
    }

    public void setPullRequestTargetBranch(Object pullRequestTargetBranch) {
        this.pullRequestTargetBranch = pullRequestTargetBranch;
    }

    public Object getPullRequestViewUrl() {
        return pullRequestViewUrl;
    }

    public void setPullRequestViewUrl(Object pullRequestViewUrl) {
        this.pullRequestViewUrl = pullRequestViewUrl;
    }

    public Object getCommitViewUrl() {
        return commitViewUrl;
    }

    public void setCommitViewUrl(Object commitViewUrl) {
        this.commitViewUrl = commitViewUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(triggeredAt);
        dest.writeValue(startedOnWorkerAt);
        dest.writeValue(environmentPrepareFinishedAt);
        dest.writeValue(finishedAt);
        dest.writeValue(slug);
        dest.writeValue(status);
        dest.writeValue(statusText);
        dest.writeValue(abortReason);
        dest.writeValue(isOnHold);
        dest.writeValue(branch);
        dest.writeValue(buildNumber);
        dest.writeValue(commitHash);
        dest.writeValue(commitMessage);
        dest.writeValue(tag);
        dest.writeValue(triggeredWorkflow);
        dest.writeValue(triggeredBy);
        dest.writeValue(machineTypeId);
        dest.writeValue(stackIdentifier);
        dest.writeValue(originalBuildParams);
        dest.writeValue(pullRequestId);
        dest.writeValue(pullRequestTargetBranch);
        dest.writeValue(pullRequestViewUrl);
        dest.writeValue(commitViewUrl);
    }

    public int describeContents() {
        return  0;
    }

}
