package kr.ac.cau.project.tickets;

import kr.ac.cau.project.tickets.entity.*;
import kr.ac.cau.project.tickets.repository.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class DataInitializer{
    private final UserinfoRepository userinfoRepository;
    private final StadiumRepository stadiumRepository;
    private final ConcertRepository concertRepository;
    private final ConcertDateRepository concertDateRepository;
    private final SeatGradeRepository seatGradeRepository;
    private final SeatRepository seatRepository;
    private final DiscountOptionsRepository discountOptionsRepository;

    public void run(){
        Member member = new Member();
        member.setUsername("john");
        userinfoRepository.save(member);

        EventStaff eventStaff = new EventStaff();
        eventStaff.setUsername("staff");
        userinfoRepository.save(eventStaff);

        Stadium stadium = new Stadium();
        stadium.setAddress("1234");
        stadium.setName("kintex");
        stadium.setExplaination("no expl");
        stadiumRepository.save(stadium);

        Concert concert = new Concert();
        concert.setName("bts concert");
        concert.setName("bts concert");
        concert.setExplaination("no expl");
        concert.setStaff(eventStaff);
        concert.setStadium(stadium);
        concertRepository.save(concert);

        ConcertDate concertdate1 = new ConcertDate();
        ConcertDate concertdate2 = new ConcertDate();
        concertdate1.setConcert(concert);
        concertdate1.setStartTime(LocalDateTime.of(2024,1,1,10,0,0));
        concertdate1.setEndTime(LocalDateTime.of(2024,1,1,12,0,0));
        concertdate2.setConcert(concert);
        concertdate2.setStartTime(LocalDateTime.of(2024,1,3,16,0,0));
        concertdate2.setEndTime(LocalDateTime.of(2024,1,3,18,0,0));
        concertDateRepository.save(concertdate1);
        concertDateRepository.save(concertdate2);

        SeatGrade gradeR = new SeatGrade();
        SeatGrade gradeS = new SeatGrade();
        gradeR.setGradeName("R");
        gradeR.setStadium(stadium);
        gradeS.setGradeName("S");
        gradeS.setStadium(stadium);
        seatGradeRepository.save(gradeR);
        seatGradeRepository.save(gradeS);

        Seat seatS1 = new Seat();
        Seat seatS2 = new Seat();
        seatS1.setSeatName("S1");
        seatS1.setGrade(gradeS);
        seatS2.setSeatName("S2");
        seatS2.setGrade(gradeS);
        seatRepository.save(seatS1);
        seatRepository.save(seatS2);

        DiscountOptions discountOptions1 = new DiscountOptions();
        DiscountOptions discountOptions2 = new DiscountOptions();
        discountOptions1.setType("card");
        discountOptions1.setDiscountRate(0.1);
        discountOptions2.setType("army");
        discountOptions2.setDiscountRate(0.05);
        discountOptionsRepository.save(discountOptions1);
        discountOptionsRepository.save(discountOptions2);
    }
}
