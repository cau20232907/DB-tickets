package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.*;
import kr.ac.cau.project.tickets.repository.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

@Component
public class MemberCli {
    public void run(Member member) {
        List<Concert> concertList;
        Concert selectedConcert;
        List<ConcertDate> concertDateList;
        ConcertDate selectedConcertDate;
        Stadium selectedStadium;
        List<SeatGrade> seatGradeList;
        SeatGrade selectedSeatGrade;
        List<Seat> seatList = null;
        List<Seat> selectedSeats = new ArrayList<>();
        TransactionQueue[] tuple = new TransactionQueue[4];
        for(int i = 0; i < 4; i++) tuple[i] = new TransactionQueue();
        Delivery delivery = new Delivery();
        FreeSeatNonpaidTicket[] fsNonpaidTickets = new FreeSeatNonpaidTicket[4];
        for(int i = 0; i < 4; i++) fsNonpaidTickets[i] = new FreeSeatNonpaidTicket();
        ReservedSeatNonpaidTicket[] rsNonpaidTickets = new ReservedSeatNonpaidTicket[4];
        for(int i = 0; i < 4; i++) rsNonpaidTickets[i] = new ReservedSeatNonpaidTicket();
        Payment payment = new Payment();
        List<DiscountOptions> discountOptionList;
        DiscountOptions selectedDiscountOption;
        FreeSeatTicket[] fsTicket = new FreeSeatTicket[4];
        for(int i = 0; i < 4; i++) fsTicket[i] = new FreeSeatTicket();
        ReservedSeatTicket[] rsTicket = new ReservedSeatTicket[4];
        for(int i = 0; i < 4; i++) rsTicket[i] = new ReservedSeatTicket();

        UserinfoApi.insert(member);

        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("0. Make a reservation\n1. Show reservation list\n2. exit");
        userInput = scanner.next();
        switch(userInput){
            case "0":
            {
                System.out.println("Choose the event");
                concertList = ConcertApi.findAllConcert();      // 전체 공연 테이블 가져오기
                for (int i = 0; i < concertList.size(); i++) {  // 공연 목록 보여주기
                    //concertList.get(i); //[i]
                    System.out.println(i + ". " + concertList.get(i).getConcertName());
                }
                userInput = scanner.next();       // 공연 선택
                selectedConcert = concertList.get(Integer.parseInt(userInput));

                System.out.println("Choose the time");
                concertDateList = ConcertDateApi.findConcertDatebyConcert(selectedConcert);     // 전체 공연날짜 가져오기
                for(int i = 0; i < concertDateList.size(); i++){        //공연날짜(시작시간) 보기
                    System.out.println(i + ". " + concertDateList.get(i).getStartTime());
                }
                userInput = scanner.next();   // 공연날짜 선택
                selectedConcertDate = concertDateList.get(Integer.parseInt(userInput));
                tuple[0].setConcertDate(selectedConcertDate);  //transaction 객체에 날짜정보 저장

                selectedStadium = selectedConcert.getStadium();     //공연장은 공연에 의해 자동으로 결정
                System.out.println("Choose seat grade");
                seatGradeList = SeatGradeApi.findSeatGradebyStadium(selectedStadium); // 전체 좌석등급 가져오기
                for(int i = 0; i < seatGradeList.size(); i++){      // 전체 좌석등급 보여주기
                    System.out.println(i + ". " + seatGradeList.get(i).getGradeName());
                }
                userInput = scanner.next();       // 좌석 등급 선택  이하의 등급 구분 column 추가 전까지는 지정석 등급만 골라야 함
                selectedSeatGrade = seatGradeList.get(Integer.parseInt(userInput));
                tuple[0].setSeatGrade(selectedSeatGrade);      //transaction 객체에 좌석등급 저장

                boolean isFree = false;
                {
                    //TODO SeatGrade 테이블이 해당 등급이 free seat인지 reserved seat인지 구분하는 column 필요할듯
                    //     isFree를 통해 free seat인지 아닌지 확인한다고 가정
                }

                int ticketNum;      // 선택한 티켓 개수, 최대 4개까지
                String[] seatNums = null;
                if(!isFree) {       // 지정석 티켓의 경우 좌석을 직접 고르게 함
                    System.out.println("Choose seat (Maximum 4)");
                    seatList = SeatApi.findSeatbyGrade(selectedSeatGrade); // 전체 좌석 가져오기
                    {
                        //TODO 미예약된 좌석만 분류하는 과정 필요
                        //     seat에 예약 되었는지 확인하는 column이 필요할 수 있음
                    }
                    for (int i = 0; i < seatList.size(); i++) {
                        System.out.println(i + ". " + seatList.get(i).getSeatName());   //전체 좌석 보여주기
                    }
                    scanner.nextLine();
                    userInput = scanner.nextLine();
                    seatNums = userInput.split(" ");
                    ticketNum = seatNums.length;
                }
                else{           // 자유석 티켓의 경우 좌석 개수만 고르게 함
                    System.out.println("Choose number of seats (Maximum 4)");
                    userInput = scanner.next();
                    ticketNum = Integer.parseInt(userInput);
                }

                System.out.println("Choose delivery option");       // 실물티켓/ 온라인티켓 선택
                System.out.println("0. delivery\n1. online");
                userInput = scanner.next();
                if (userInput.equals("0")) {        // 실물티켓의 경우 유저에게서 배달 정보를 입력받음
                    tuple[0].setIsOnline(false);
                    System.out.print("Please enter delivery company: ");
                    userInput = scanner.next();
                    delivery.setDeliveryCompany(userInput);
                    System.out.print("Please enter delivery address: ");
                    userInput = scanner.next();
                    delivery.setArrivalAddress(userInput);
                    delivery.setDeliveryCode(String.valueOf(delivery.getId()));   // 배송 코드의 경우 일단 ID와 동일하게 지정
                    DeliveryApi.insert(delivery);       // delivery 테이블에 입력받은 배송정보 insert
                }
                else tuple[0].setIsOnline(true);

                tuple[0].setMember(member);
                if(!isFree){        // 지정석 티켓의 경우 transaction 객체에 좌석정보 포함하여 저장
                    for(int i = 0; i < ticketNum; i++){
                        selectedSeats.add(seatList.get(Integer.parseInt(seatNums[i])));
                        tuple[i].setConcertDate(tuple[0].getConcertDate());     // 좌석 개수만큼 transaction 객체에 정보 복사
                        tuple[i].setSeatGrade(tuple[0].getSeatGrade());
                        tuple[i].setIsOnline(tuple[0].getIsOnline());
                        tuple[i].setMember(tuple[0].getMember());
                        tuple[i].setSeat(selectedSeats.get(i));
                        tuple[i].setTime(LocalDateTime.now());
                    }
                }
                else{               // 자유석 티켓의 경우 transaction 객체에 좌석정보 미포함
                    for(int i = 0; i < ticketNum; i++){
                        tuple[i].setConcertDate(tuple[0].getConcertDate());     // 좌석 개수만큼 transaction 객체에 정보 복사
                        tuple[i].setSeatGrade(tuple[0].getSeatGrade());
                        tuple[i].setIsOnline(tuple[0].getIsOnline());
                        tuple[i].setMember(tuple[0].getMember());
                        tuple[i].setSeat(null);
                        tuple[i].setTime(LocalDateTime.now());      // 트랜젝션에 저장된 시간
                    }
                }
                for(int i = 0; i < ticketNum; i++){
                    TransactionQueueApi.insert(tuple[i]);   // transaction queue에 입력된 tuple insert
                }

                // transaction(tuple)을 통해 미결제 티켓 생성
                System.out.println("Tickets are in shopping basket");
                if(!isFree){        // 지정석 티켓의 경우 좌석 정보 포함
                    for (int i = 0; i < ticketNum; i++) {
                        rsNonpaidTickets[i].setConcertDate(tuple[i].getConcertDate());
                        rsNonpaidTickets[i].setIsOnline(tuple[i].getIsOnline());
                        if (rsNonpaidTickets[i].getIsOnline()) rsNonpaidTickets[i].setDelivery(null);
                        else rsNonpaidTickets[i].setDelivery(delivery);
                        rsNonpaidTickets[i].setSeat(tuple[i].getSeat());
                        rsNonpaidTickets[i].setPurchaseTime(tuple[i].getTime());

                    }
                    for(int i = 0; i < ticketNum; i++){
                        NonpaidTicketApi.insert(rsNonpaidTickets[i]);
                    }
                }
                else{               // 자유석 티켓의 경우 좌석등급 정보 포함
                    for (int i = 0; i < ticketNum; i++) {
                        fsNonpaidTickets[i].setConcertDate(tuple[i].getConcertDate());
                        fsNonpaidTickets[i].setIsOnline(tuple[i].getIsOnline());
                        if (fsNonpaidTickets[i].getIsOnline()) fsNonpaidTickets[i].setDelivery(null);
                        else fsNonpaidTickets[i].setDelivery(delivery);
                        fsNonpaidTickets[i].setSeat(tuple[i].getSeatGrade());
                        fsNonpaidTickets[i].setPurchaseTime(tuple[i].getTime());
                        FreeSeatNonpaidTicketApi.insert(fsNonpaidTickets[i]);
                        FreeSeatNonpaidTicketApi.insert(fsNonpaidTickets[i]);
                    }
                    for(int i = 0; i < ticketNum; i++){
                        NonpaidTicketApi.insert(fsNonpaidTickets[i]);   // 미결제 티켓 테이블에 티켓 insert
                    }
                }
                
                // 결제 진행 
                payment.setMember(member);
                System.out.println("Payment in progress");
                System.out.println("Choose discount option");
                discountOptionList = DiscountOptionsApi.findAllDiscountOptions();      // 할인 옵션 보여주기 & 선택
                for(int i = 0; i < discountOptionList.size(); i++){
                    System.out.println(i + ". " + discountOptionList.get(i).getType() + " : " +
                            discountOptionList.get(i).getDiscountRate() * 100 + "%");
                }
                userInput = scanner.next();
                selectedDiscountOption = discountOptionList.get(Integer.parseInt(userInput));
                payment.setSelectedDiscountOptions(selectedDiscountOption);
                payment.setPaymentCode(String.valueOf(payment.getId()));    // 결제 코드는 일단 ID와 동일하게 지정
                payment.setPaymentTime(LocalDateTime.now());        // 결제가 진행되는 시간
                {
                    //TODO 좌석별로 가격을 설정하는 column 필요할듯
                    //     최종 가격은 (티켓가격 * 티켓수)*할인률
                }
                payment.setTotalBalance((int) selectedDiscountOption.getDiscountRate());    //좌석 가격에 할인률 적용
                PaymentApi.insert(payment);     // 결제테이블에 결제 내용 insert

                // 결제 끝난고 실제 티켓 생성
                System.out.println("creating tickets");
                if(!isFree){
                    for(int i = 0; i < ticketNum; i++){
                        rsTicket[i].setPayment(payment);
                        rsTicket[i].setPurchaseTime(rsNonpaidTickets[i].getPurchaseTime());
                        rsTicket[i].setConcertDate(rsNonpaidTickets[i].getConcertDate());
                        rsTicket[i].setDelivery(rsNonpaidTickets[i].getDelivery());
                        rsTicket[i].setIsOnline((rsNonpaidTickets[i].getIsOnline()));
                        rsTicket[i].setSeat(rsNonpaidTickets[i].getSeat());
                    }
                    for(int i = 0; i < ticketNum; i++){
                        TicketApi.insert(rsTicket[i]);      // 티켓 테이블에 지정석 티켓 insert
                    }
                }
                else{
                    for(int i = 0; i < ticketNum; i++){
                        fsTicket[i].setPayment(payment);
                        fsTicket[i].setPurchaseTime(fsNonpaidTickets[i].getPurchaseTime());
                        fsTicket[i].setConcertDate(fsNonpaidTickets[i].getConcertDate());
                        fsTicket[i].setDelivery(fsNonpaidTickets[i].getDelivery());
                        fsTicket[i].setIsOnline((fsNonpaidTickets[i].getIsOnline()));
                        fsTicket[i].setSeat(fsNonpaidTickets[i].getSeat());
                    }
                    for(int i = 0; i < ticketNum; i++){
                        TicketApi.insert(fsTicket[i]);      // 티켓 테이블에 자유석 티켓 insert
                    }
                }
            }
            break;
            case "1":
                List<Payment> searchPayment;
                searchPayment = PaymentApi.findPaymentByMember(member);     // member의 결제 기록 가져오기
                List<Ticket>[] searchTicket = new ArrayList[]{new ArrayList<>()};
                for(int i = 0; i < searchPayment.size(); i++){
                    searchTicket[i] = TicketApi.findTicketByPayment(searchPayment.get(i));  // 결제기록마다 구매한 티켓들 가져오기
                }
                System.out.println("Purchased Tickets");
                for(int i = 0; i < searchPayment.size(); i++){
                    for(int j = 0; j < searchTicket[i].size(); j++){
                        {
                            //TODO 지연로딩 오류 해소 필요
                        }
                        //System.out.println("Concert: " + searchTicket[i].get(j).getConcertDate().getId());
                        //System.out.println("Date: " + searchTicket[i].get(j).getPayment().getPaymentTime());
                        //System.out.println("Price: " + searchTicket[i].get(j).getPayment().getTotalBalance());
                        {
                            //TODO 일단 지연로딩 오류 안걸리는 column만 출력합니다.
                        }
                        System.out.println("ticket Id: " + searchTicket[i].get(j).getId());
                        System.out.println("purchase time: " + searchTicket[i].get(j).getPurchaseTime());
                        System.out.println("online ticket: " + searchTicket[i].get(j).getIsOnline());
                    }
                }
                break;
            case "2":
                System.exit(0);
        }
    }
}

