package kr.ac.cau.project.tickets;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicketsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 */
	@Override
	public void run(String... args) {
		//CLI 구현 위치
		System.out.println("CLI start!");
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(input.next());
		}
	}
}
