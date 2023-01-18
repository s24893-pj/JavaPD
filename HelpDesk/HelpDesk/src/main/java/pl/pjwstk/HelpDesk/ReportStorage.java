package pl.pjwstk.HelpDesk;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportStorage {

    private final List<Report> reportList = new ArrayList<>();

    ReportStorage(){}
    public List<Report> getReportList(){
        return reportList;
    }

    public Report findByID(int Id){
        for (Report report : reportList){
            if (report.getReportId() == Id){
                return report;
            }
        }
        return null;
    }
}
