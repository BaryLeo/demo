package mybatis;

public class Job {
    private Integer jobId;

    private String jobName;

    private String jobMark;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobMark() {
        return jobMark;
    }

    public void setJobMark(String jobMark) {
        this.jobMark = jobMark == null ? null : jobMark.trim();
    }
}