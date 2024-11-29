package kr.ac.cau.project.tickets;

import kr.ac.cau.project.tickets.cli.MemberCli;
import kr.ac.cau.project.tickets.cli.StaffCli;
import kr.ac.cau.project.tickets.entity.EventStaff;
import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.Userinfo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class TicketsApplication implements CommandLineRunner {
	private final MemberCli memberCli;
	private final StaffCli staffCli;

		public static void main(String[] args){
		SpringApplication.run(TicketsApplication.class, args);


		}

	@Override
	public void run(String... args) throws Exception{

		/*Connector connector = new Connector();
		connector.dbConnection();
		Statement state = connector.dbconn.createStatement();
		ResultSet result = state.executeQuery("select id, name, dept_name from university.student order by name");
		result.next();
		String name;
		String Id;
		String dept_name;
		int select_limit = 10;
		int count = 0;
		while(result.next() && count < select_limit ) {
			name = result.getString("name");
			Id = result.getString("ID");
			dept_name = result.getString("dept_name");
			System.out.println(name + " " + Id + " " + dept_name);
			count++;
		}

		while (result.next()) {
			System.out.print("1. Show events\n2. Make reservation\n3. Exit\n");
			inputString = input.next();
			switch(inputString){
				case "1":
					System.out.print("1. By date\n 2. By Stadium\n3. By event\n4. Back to main\n");
					inputString = input.next();
					break;
				case "2":
			}
		}

		result.close();
		state.close();
		connector.dbClose();*/

		String ID;
		String password;
		String userInput;
		Userinfo user1=null;
		Scanner input = new Scanner(System.in);
		System.out.println("Ticketing DB");
		while(true){
			System.out.println("Login page");
			System.out.println("Id: ");
			ID = input.next();
			System.out.println("Password: ");
			password = input.next();
			{
				//TODO userinfo table과 id, password 비교해서 로그인
			}

			if (user1==null){
				System.out.println(";;");
			} else if (user1 instanceof Member member) {
				memberCli.run(member);
			} else if (user1 instanceof EventStaff staff){
				staffCli.run(staff);
			}
//			if(user1.getUsername() == ){
//				System.out.println("1. Show Payment log\n2. Show Transaction queue log\n3. ");
//				userInput = input.next();
//			}
//			else if (user1.get){
//				System.out.println("1. Show Events\n2. ");
//				userInput = input.next();
//				switch(userInput){
//					case "1":
//
//				}
//			}
		}
	}
}
