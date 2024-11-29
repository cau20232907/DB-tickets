package kr.ac.cau.project.tickets;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.sql.*;



@SpringBootApplication
public class TicketsApplication implements CommandLineRunner {

		public static void main(String[] args){
		SpringApplication.run(TicketsApplication.class, args);


		}

	@Override
	public void run(String... args) throws Exception{
		Connector connector = new Connector();
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

		String inputString;
		System.out.println("Ticketing DB");
		Scanner input = new Scanner(System.in);
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
		connector.dbClose();
	}

}
