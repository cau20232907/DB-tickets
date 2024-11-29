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

			if (user1 == null){
				System.out.println(";;");
			} else if (user1 instanceof Member member) {
				memberCli.run(member);
			} else if (user1 instanceof EventStaff staff){
				staffCli.run(staff);
			}
		}
	}
}
