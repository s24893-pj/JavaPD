package pl.pjwstk.HelpDesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpDeskApplication {

	public HelpDeskApplication(HelpService helpService){
		User user1 = new User("1");
		User user2 = new User("2");
		User user3 = new User("3");

		helpService.createAReport(user1, "Nie dziala", "przyjeto", "1");
		helpService.createAReport(user2, "Nie dziala", "przyjeto", "2");
		helpService.createAReport(user3, "Nie dziala", "przyjeto", "3");
		helpService.createAReport(user3, "Nie dziala", "przyjeto", "6");


		helpService.changeReportStatus(1, "w realizacji");
		helpService.changeReportStatus(4, "w realizacji");

		System.out.println();

		helpService.changeConsultant(2, "4");
		helpService.changeConsultant(2, "8");

		System.out.println();

		helpService.viewReportInfo(3);
		System.out.println("\n");
		System.out.println(helpService.getAllReports());


	}

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

}
