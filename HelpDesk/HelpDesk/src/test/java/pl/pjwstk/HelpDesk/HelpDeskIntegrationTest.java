package pl.pjwstk.HelpDesk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HelpDeskIntegrationTest {
    @MockBean
    private ReportStorage reportStorage;
    @MockBean
    private ConsultantStorage consultantStorage;

    @Autowired
    private HelpService helpService;

    @Test
    void ContextLoad(){

    }

    public void viewReportInfo(int reportId) {
        if (reportStorage.findByID(reportId) != null) {
            System.out.println(reportStorage.findByID(reportId).toString());
        } else {
            System.out.println("Takie zgloszenie nie istnieje");
        }
    }

    @Test
    void shouldReturnReport(){
        when(reportStorage.findByID(anyInt())).thenReturn(new Report(new User("1"), "nie działa", "przyjęto", "1"));
        //Given
        int Id = 1;
        ResponseEntity<String> response = reportStorage.findByID(1);
        //When
        Report report = reportStorage.findByID(Id);
        //Then
        assertThat().isEqualTo();
    }
}
