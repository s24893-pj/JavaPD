package pl.pjwstk.HelpDesk;

public class Consultant {

    private String consultantId;
    private String office;

    public Consultant(String consultantId,String office){
        this.consultantId = consultantId;
        this.office = office;
    }
    public String getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(String consultantId) {
        this.consultantId = consultantId;
    }

    public String getOfficee() {
        return office;
    }

    public void setOffice(String site) {
        this.office = site;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "consultantId='" + consultantId + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}
