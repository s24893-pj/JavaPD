package pl.pjwstk.HelpDesk;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelpService {

    private final ConsultantStorage consultantStorage;
    private final ReportStorage reportStorage;

    public HelpService(ConsultantStorage consultantStorage, ReportStorage reportStorage) {
        this.consultantStorage = consultantStorage;
        this.reportStorage = reportStorage;
    }

    public List<Report> getAllReports() {
        return reportStorage.getReportList();
    }

    public Report createAReport(User user, String problem, String status, String consultantId) {
        if (consultantStorage.checkConsultantExist(consultantId)) {
//            System.out.println("stworzono zgloszenie");
            Report report = new Report(user, problem, status, consultantId);
            reportStorage.getReportList().add(report);
            return report;
        } else {
            System.out.println("Nie ma takiego konsultanta");
            return null;
        }
    }

    public void changeReportStatus(int reportId, String status) {
        if (reportStorage.findByID(reportId) != null) {
            reportStorage.findByID(reportId).setStatus(status);
            System.out.println("zmieniono status zgloszenia");
        } else {
            System.out.println("Takie zgloszenie nie istnieje");
        }
    }

    public void changeConsultant(int reportId, String consultantId) {
        if (reportStorage.findByID(reportId) != null) {
            if (consultantStorage.checkConsultantExist(consultantId)) {
                reportStorage.findByID(reportId).setConsultantId(consultantId);
                System.out.println("zmieniono konsultanta");
            } else {
                System.out.println("konsultant nie istnieje");
            }

        } else {
            System.out.println("Takie zgloszenie nie istnieje");
        }
    }

    public void viewReportInfo(int reportId) {
        if (reportStorage.findByID(reportId) != null) {
            System.out.println(reportStorage.findByID(reportId).toString());
        } else {
            System.out.println("Takie zgloszenie nie istnieje");
        }
    }
}
