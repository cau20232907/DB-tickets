package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.*;
import kr.ac.cau.project.tickets.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
@RequiredArgsConstructor
public class MemberCli {
    private final ConcertService concertService;
    private final ConcertDateService concertDateService;
    private final SeatGradeService seatGradeService;
    private final SeatService seatService;
    private final TransactionQueueService transactionQueueService;
    private final DiscountOptionsService discountOptionsService;
    private final NonpaidTicketService nonpaidTicketService;
    private final PaymentService paymentService;
    private final TicketService ticketService;
    private final DeliveryService deliveryService;

    public void run(Member member) {
//        Delivery delivery = new Delivery();
//        FreeSeatNonpaidTicket[] fsNonpaidTickets = new FreeSeatNonpaidTicket[4];
//        for(int i = 0; i < 4; i++) fsNonpaidTickets[i] = new FreeSeatNonpaidTicket();
//        ReservedSeatNonpaidTicket[] rsNonpaidTickets = new ReservedSeatNonpaidTicket[4];
//        for(int i = 0; i < 4; i++) rsNonpaidTickets[i] = new ReservedSeatNonpaidTicket();
//        FreeSeatTicket[] fsTicket = new FreeSeatTicket[4];
//        for(int i = 0; i < 4; i++) fsTicket[i] = new FreeSeatTicket();
//        ReservedSeatTicket[] rsTicket = new ReservedSeatTicket[4];
//        for(int i = 0; i < 4; i++) rsTicket[i] = new ReservedSeatTicket();

        //UserinfoRepository.insert(member);

        String userInput;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0. Make a reservation\n1. Show reservation list\n2. exit\n3. Make a payment");
            try {
                userInput = scanner.next();
                switch (userInput) {
                    case "0": {
                        List<Concert> concertList;
                        Concert selectedConcert;
                        List<ConcertDate> concertDateList;
                        ConcertDate selectedConcertDate;
                        Stadium selectedStadium;
                        List<SeatGrade> seatGradeList;
                        SeatGrade selectedSeatGrade;
                        List<Seat> seatList = null;
                        TransactionQueue queueData = new TransactionQueue();
                        System.out.println("Choose the event");
                        concertList = concertService.findAll();      // 전체 공연 테이블 가져오기
                        for (int i = 0; i < concertList.size(); i++) {  // 공연 목록 보여주기
                            //concertList.get(i); //[i]
                            System.out.println(i + ". " + concertList.get(i).getName());
                        }
                        userInput = scanner.next();       // 공연 선택
                        selectedConcert = concertList.get(Integer.parseInt(userInput));

                        System.out.println("Choose the time");
                        concertDateList = concertDateService.findByConcert(selectedConcert);     // 전체 공연날짜 가져오기
                        for (int i = 0; i < concertDateList.size(); i++) {        //공연날짜(시작시간) 보기
                            System.out.println(i + ". " + concertDateList.get(i).getStartTime());
                        }
                        userInput = scanner.next();   // 공연날짜 선택
                        selectedConcertDate = concertDateList.get(Integer.parseInt(userInput));
                        queueData.setConcertDate(selectedConcertDate);  //transaction 객체에 날짜정보 저장

                        selectedStadium = selectedConcert.getStadium();     //공연장은 공연에 의해 자동으로 결정
                        System.out.println("Choose seat grade");
                        seatGradeList = seatGradeService.findByStadium(selectedStadium); // 전체 좌석등급 가져오기
                        for (int i = 0; i < seatGradeList.size(); i++) {      // 전체 좌석등급 보여주기
                            System.out.println(i + ". " + seatGradeList.get(i).getGradeName());
                        }
                        userInput = scanner.next();       // 좌석 등급 선택  이하의 등급 구분 column 추가 전까지는 지정석 등급만 골라야 함
                        selectedSeatGrade = seatGradeList.get(Integer.parseInt(userInput));
                        queueData.setSeatGrade(selectedSeatGrade);      //transaction 객체에 좌석등급 저장

                        boolean isFree = false;
                        {
                            //SeatGrade 테이블이 해당 등급이 free seat인지 reserved seat인지 구분
                            isFree = selectedSeatGrade.getIsFree();
                        }

                        TicketPurchaseLimit ticketPurchaseLimit = ticketService.getTicketPurchaseLimit();
                        int ticketNum;      // 선택한 티켓 개수, 최대 4개까지
                        String[] seatNums = null;
                        if (!isFree) {       // 지정석 티켓의 경우 좌석을 직접 고르게 함
                            System.out.println("Choose seat (Maximum " + ticketPurchaseLimit.getValue() + ")");
                            //seatList = seatService.findByGrade(selectedSeatGrade); // 전체 좌석 가져오기
                            {
                                //미예약된 좌석만 분류하는 과정
                                seatList = seatService.findRemainingByGrade(selectedConcertDate, selectedSeatGrade);
                            }
                            for (int i = 0; i < seatList.size(); i++) {
                                System.out.println(i + ". " + seatList.get(i).getSeatName());   //전체 좌석 보여주기
                            }
                            scanner.nextLine();
                            userInput = scanner.nextLine();
                            seatNums = userInput.split(" ");
                            ticketNum = seatNums.length;
                        } else {           // 자유석 티켓의 경우 좌석 개수만 고르게 함
                            System.out.println("Choose number of seats (Maximum " + ticketPurchaseLimit.getValue() + ")");
                            userInput = scanner.next();
                            ticketNum = Integer.parseInt(userInput);
                        }

                        if (ticketNum > ticketPurchaseLimit.getValue()) {
                            System.out.println("Only up to " + ticketPurchaseLimit.getValue() + " tickets available.");
                            break;
                        }

                        List<TransactionQueue> tuple;
                        List<Seat> selectedSeats = new ArrayList<>();

                        queueData.setMember(member);
                        if (!isFree) {        // 지정석 티켓의 경우 transaction 객체에 좌석정보 포함하여 저장
                            selectedSeats = Arrays.stream(seatNums)
                                    .mapToInt(Integer::parseInt)
                                    .mapToObj(seatList::get)
                                    .toList();
                            tuple = queueData.copyBySeat(selectedSeats);
                        } else {               // 자유석 티켓의 경우 transaction 객체에 좌석정보 미포함
                            selectedSeats = new ArrayList<>();
                            for (int i = 0; i < ticketNum; i++) selectedSeats.add(null);
                            tuple = queueData.copyBySeat(selectedSeats);
                        }
                        transactionQueueService.saveAll(tuple);   // transaction queue에 입력된 tuple insert
                    }
                    break;

                    //Nonpaid ticket은 DB가 생성함(프로시저)

                    // transaction(tuple)을 통해 미결제 티켓 생성
//                System.out.println("Tickets are in shopping basket");
//                if(!isFree){        // 지정석 티켓의 경우 좌석 정보 포함
//                    for (int i = 0; i < ticketNum; i++) {
//                        rsNonpaidTickets[i].setConcertDate(tuple[i].getConcertDate());
//                        rsNonpaidTickets[i].setIsOnline(tuple[i].getIsOnline());
//                        if (rsNonpaidTickets[i].getIsOnline()) rsNonpaidTickets[i].setDelivery(null);
//                        else rsNonpaidTickets[i].setDelivery(delivery);
//                        rsNonpaidTickets[i].setSeat(tuple[i].getSeat());
//                        rsNonpaidTickets[i].setPurchaseTime(tuple[i].getTime());
//
//                    }
//                    for(int i = 0; i < ticketNum; i++){
//                        NonpaidTicketService.insert(rsNonpaidTickets[i]);
//                    }
//                }
//                else{               // 자유석 티켓의 경우 좌석등급 정보 포함
//                    for (int i = 0; i < ticketNum; i++) {
//                        fsNonpaidTickets[i].setConcertDate(tuple[i].getConcertDate());
//                        fsNonpaidTickets[i].setIsOnline(tuple[i].getIsOnline());
//                        if (fsNonpaidTickets[i].getIsOnline()) fsNonpaidTickets[i].setDelivery(null);
//                        else fsNonpaidTickets[i].setDelivery(delivery);
//                        fsNonpaidTickets[i].setSeat(tuple[i].getSeatGrade());
//                        fsNonpaidTickets[i].setPurchaseTime(tuple[i].getTime());
//                        FreeSeatNonpaidTicketService.insert(fsNonpaidTickets[i]);
//                        FreeSeatNonpaidTicketService.insert(fsNonpaidTickets[i]);
//                    }
//                    for(int i = 0; i < ticketNum; i++){
//                        NonpaidTicketService.insert(fsNonpaidTickets[i]);   // 미결제 티켓 테이블에 티켓 insert
//                    }
//                }

                    case "3": {
                        // TODO: 결제할 티켓 찾기 (현재는 미결제 전체를 가져옴)
                        List<NonpaidTicket> targetTickets = nonpaidTicketService.findByMember(member);
                        // 결제 진행
                        System.out.println("Payment in progress");
                        System.out.println("Choose discount option. If None, enter 0");
                        // 할인 옵션 보여주기 & 선택
                        List<DiscountOptions> discountOptionList = discountOptionsService.findAll();
                        for (int i = 0; i < discountOptionList.size(); i++) {
                            System.out.println((i + 1) + ". " + discountOptionList.get(i).getType() + " : " +
                                    discountOptionList.get(i).getDiscountRate() * 100 + "%");
                        }
                        userInput = scanner.next();

                        int inputVal = Integer.parseInt(userInput);
                        double discountRate;
                        DiscountOptions selectedDiscountOption;
                        if (inputVal == 0) {
                            selectedDiscountOption = null;
                            discountRate = 1;
                        } else {
                            selectedDiscountOption = discountOptionList.get(inputVal - 1);
                            discountRate = selectedDiscountOption.getDiscountRate();
                        }

                        // 최종 가격은 (티켓가격 * 티켓수)*할인률
                        int totalBalance = targetTickets.stream()
                                .mapToInt(t -> t.getSeatGrade().getPrice())
                                .sum();
                        totalBalance *= discountRate;

                        Payment payment = Payment.builder()
                                .member(member)
                                .selectedDiscountOptions(selectedDiscountOption)
                                .paymentCode(UUID.randomUUID().toString()) //임시 변수
                                .paymentTime(LocalDateTime.now())
                                .totalBalance(totalBalance)    //좌석 가격에 할인률 적용
                                .build();

                        paymentService.save(payment, targetTickets);     // 결제테이블에 결제 내용 insert

//                // 결제 끝난고 실제 티켓 생성
//                System.out.println("creating tickets");
//                if(!isFree){
//                    for(int i = 0; i < ticketNum; i++){
//                        rsTicket[i].setPayment(payment);
//                        rsTicket[i].setPurchaseTime(rsNonpaidTickets[i].getPurchaseTime());
//                        rsTicket[i].setConcertDate(rsNonpaidTickets[i].getConcertDate());
//                        rsTicket[i].setDelivery(rsNonpaidTickets[i].getDelivery());
//                        rsTicket[i].setIsOnline((rsNonpaidTickets[i].getIsOnline()));
//                        rsTicket[i].setSeat(rsNonpaidTickets[i].getSeat());
//                    }
//                    for(int i = 0; i < ticketNum; i++){
//                        TicketService.insert(rsTicket[i]);      // 티켓 테이블에 지정석 티켓 insert
//                    }
//                }
//                else{
//                    for(int i = 0; i < ticketNum; i++){
//                        fsTicket[i].setPayment(payment);
//                        fsTicket[i].setPurchaseTime(fsNonpaidTickets[i].getPurchaseTime());
//                        fsTicket[i].setConcertDate(fsNonpaidTickets[i].getConcertDate());
//                        fsTicket[i].setDelivery(fsNonpaidTickets[i].getDelivery());
//                        fsTicket[i].setIsOnline((fsNonpaidTickets[i].getIsOnline()));
//                        fsTicket[i].setSeat(fsNonpaidTickets[i].getSeat());
//                    }
//                    for(int i = 0; i < ticketNum; i++){
//                        TicketService.insert(fsTicket[i]);      // 티켓 테이블에 자유석 티켓 insert
//                    }
//                }

                        //delivery 옵션
                        System.out.println("Choose delivery option");       // 실물티켓/ 온라인티켓 선택
                        System.out.println("0. delivery\n1. online");
                        userInput = scanner.next();
                        if (userInput.equals("0")) {        // 실물티켓의 경우 유저에게서 배달 정보를 입력받음
                            List<Ticket> targets = ticketService.findByPayment(payment); //저장 확인을 겸함
                            //tuple[0].setIsOnline(false);
//                    System.out.print("Please enter delivery company: ");
//                    userInput = scanner.next();
//                    delivery.setDeliveryCompany(userInput);
                            System.out.print("Please enter delivery address: ");
                            userInput = scanner.next();
                            deliveryService.save(targets, userInput);
//                    delivery.setArrivalAddress(userInput);
//                    delivery.setDeliveryCode(String.valueOf(delivery.getId()));   // 배송 코드의 경우 일단 ID와 동일하게 지정
//                    DeliveryService.insert(delivery);       // delivery 테이블에 입력받은 배송정보 insert
                        }
                        //else tuple[0].setIsOnline(true);
                    }
                    break;
                    case "1":
                        //그냥 member 기준으로 ticket기록 긁어도 상관없는데...
                        List<Payment> searchPayment;
                        searchPayment = paymentService.findByMember(member);     // member의 결제 기록 가져오기
//                List<Ticket>[] searchTicket = new ArrayList[]{new ArrayList<>()};
//                for(int i = 0; i < searchPayment.size(); i++){
//                    searchTicket[i] = ticketService.findByPayment(searchPayment.get(i));  // 결제기록마다 구매한 티켓들 가져오기
//                }
                        List<List<Ticket>> searchTicket = searchPayment.stream().map(ticketService::findByPayment).toList();
                        System.out.println("Purchased Tickets");
                        for (int i = 0; i < searchPayment.size(); i++) {
                            System.out.println("Payment Date: " + searchPayment.get(i).getPaymentTime());
                            System.out.println("Total Balance: " + searchPayment.get(i).getTotalBalance());

                            for (Ticket ticket : searchTicket.get(i)) {
                                System.out.println("\tConcert: " + ticket.getConcertDate().getConcert().getName());
                                System.out.println("\tConcert Date: " + ticket.getConcertDate().getStartTime());
                                System.out.println("\tPrice: " + (int) (ticket.getSeatGrade().getPrice() *
                                        Optional.ofNullable(ticket.getPayment().getSelectedDiscountOptions())
                                                .orElse(DiscountOptions.builder().discountRate(1.0).build()).getDiscountRate()));
                                System.out.println("\tPurchase time: " + ticket.getPurchaseTime());
                                System.out.println("\tOnline ticket: " + ticket.getIsOnline());
                                System.out.println();
                            }
                        }
                        break;
                    case "2":
                        return;
                    case "4":
                        //TODO: 결제 변경
                    case "5":
                        //TODO: 결제 기록 보기
                }
            } catch (Exception e) {
                System.out.println("Error occured. Please try again");
            }
        }
    }
}