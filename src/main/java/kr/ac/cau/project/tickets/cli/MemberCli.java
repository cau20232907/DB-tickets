package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MemberCli {
    public void run(Member member) {
        List<Concert> concertList;
        Concert selectedConcert;
        List<ConcertDate> concertDateList;
        ConcertDate selectedConcertDate;
        Stadium stadium = null;
        SeatGrade seatGrade = null;
        TransactionQueue tuple = new TransactionQueue();
        //EntityManager em;
        //EntityTransaction tx = em.getTransaction();
        String userInput;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Show Events\n2. reservation list\n3. exit");
        userInput = input.next();
        switch(userInput){
            case "1":
            {
                concertList = ConcertApi.findAllConcert();
                System.out.println("Choose the event you want.");
                for (int i = 0; i < concertList.size(); i++) {
                    //concertList.get(i); //[i]
                    System.out.println(i + ". " + concertList.get(i).getConcertName());
                }
                userInput = input.next();
                selectedConcert = concertList.get(Integer.parseInt(userInput));

                //long ConcertId = concertList.get(Integer.parseInt(userInput)).getId();
                concertDateList = ConcertDateApi.findConcertDatebyId(selectedConcert.getId());
                for(int i = 0; i < concertDateList.size(); i++){
                    System.out.println(i + ". " + concertDateList.get(i).getStartTime());
                }
                userInput = input.next();
                selectedConcertDate = concertDateList.get(Integer.parseInt(userInput));
                tuple.setConcertDate(selectedConcertDate);

                stadium.setId(selectedConcert.getStadium().getId());



            }
            case "2":

        }
    }
}

