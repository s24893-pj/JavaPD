package pl.pjwstk.HelpDesk;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultantStorage {

    private final List<Consultant> consultants = new ArrayList<>();

    ConsultantStorage(){
        this.consultants.add(new Consultant("1","Koscierzyna"));
        this.consultants.add(new Consultant("2","Gdansk"));
        this.consultants.add(new Consultant("3","Gdnynia"));
        this.consultants.add(new Consultant("4","Wejherowo"));
        this.consultants.add(new Consultant("5","Tczew"));

        for (Consultant consultant : consultants){
            System.out.println(consultant);
        }
    }
    public List<Consultant> getConsultants(){
        return consultants;
    }

    public boolean checkConsultantExist(String Id){
        for (Consultant consultant : consultants){
            if (consultant.getConsultantId().equals(Id)){
                return true;
            }
        }
        return false;
    }
}
