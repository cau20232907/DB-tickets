package kr.ac.cau.project.tickets;

import kr.ac.cau.project.tickets.cli.MemberCli;
import kr.ac.cau.project.tickets.cli.StaffCli;
import kr.ac.cau.project.tickets.entity.EventStaff;
import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.Userinfo;
import kr.ac.cau.project.tickets.service.UserinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories
public class TicketsApplication implements CommandLineRunner {
	private final MemberCli memberCli;
	private final StaffCli staffCli;
	private final UserinfoService userinfoService;
	//private final DataInitializer dataInitializer;

		public static void main(String[] args){
		SpringApplication.run(TicketsApplication.class, args);


		}

	@Override
	public void run(String... args) throws Exception{
		//dataInitializer.run();		// db 테이블 초기설정
		String ID;
		String password;
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
				user1 = userinfoService.login(ID, password);
			}

			if (user1 == null){
				System.out.println("incorrect username or password.");
				System.out.println("sign in with this? (y/n)");
				if (input.next().equalsIgnoreCase("y")) {
					if (userinfoService.ifUsernameUsable(ID))
						userinfoService.signin(ID, password);
					else System.out.println("this username is already used.");
				}
			} else if (user1 instanceof Member member1) {
				memberCli.run(member1);
			} else if (user1 instanceof EventStaff staff){
				staffCli.run(staff);
			}
		}
	}
}
