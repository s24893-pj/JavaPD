package pl.pjwstk.HelpDesk;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelpDeskTest {

    @Mock
    private ReportStorage reportStorage;
    @Mock
    private ConsultantStorage consultantStorage;
    @InjectMocks
    HelpService helpService;

    //Konsultant nie istnieje przy tworzeniu zgłoszenia
    @Test
    void helpServiceTest() {
        //Given
//        List<Report> reports = new ArrayList<>();
//        Consultant consultant = new Consultant("1", "Gdansk");
//        reports.add(new Report(new User("1"), "Nie działa", "przyjęto", "1"));
        when(consultantStorage.checkConsultantExist(any())).thenReturn(false);
//        when(reportStorage.getReportList()).thenReturn(reports);

        User user = new User("1");
        String problem = "nie działa";
        String status = "przyjeto";
        String consultantId = "1";
        //When
        Report report = helpService.createAReport(user, problem, status, consultantId);
        //Then
        assertThat(report).isEqualTo(null);

    }


    //Konsultant nie istnieje przy edycji zgłoszenia
    @Test
    void helpServiceTest2() {
        //Given
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(new User("1"), "Nie działa", "przyjęto", "1"));
        when(consultantStorage.checkConsultantExist(any())).thenReturn(false);
        when(reportStorage.findByID(1)).thenReturn(reports.get(0));

        int problemId = 1;
        String consultantId = "2";
        //When
        helpService.changeConsultant(problemId, consultantId);
        //Then
        assertThat(reports.get(0).getConsultantId()).isEqualTo("1");

    }

    //Report nie istnieje przy zmianie statusu
    @Test
    void helpServiceTest3() {
        //Given
        when(reportStorage.findByID(1)).thenReturn(null);

        int problemId = 1;
        String status = "w realizacji";
        //When
        helpService.changeReportStatus(problemId, status);
        //Then
        assertThat(reportStorage.findByID(problemId)).isEqualTo(null);
    }
}
