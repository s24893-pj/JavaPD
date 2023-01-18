package pl.pjwstk.HelpDesk;

import java.util.Date;

public class Report {
    private static int count = 0;
    private User user;
    private String consultantId;
    private int reportId;
    private String problem;
    private String status;

    public User getUser() {
        return user;
    }

    public Report(User user, String problem, String status, String consultantId){
        this.user = user;
        this.reportId = ++count;
        this.problem = problem;
        this.status = status;
        this.consultantId = consultantId;
    }
    public int getReportId() {
        return reportId;
    }

    public void setConsultantId(String consultantId) {
        this.consultantId = consultantId;
    }

    public String getConsultantId() {
        return consultantId;
    }

    public String getProblem() {
        return problem;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " Report{" +
                "userID=`" + user.getUserId() + '\'' +
                ", consultantID='" + consultantId + '\'' +
                ", reportID=" + reportId +
                ", problem='" + problem + '\'' +
                ", status='" + status + '\'' +
                "}\n";
    }
}
