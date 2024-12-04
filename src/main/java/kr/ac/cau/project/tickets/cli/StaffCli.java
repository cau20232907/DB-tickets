package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.*;
import kr.ac.cau.project.tickets.repository.StadiumRepository;
import kr.ac.cau.project.tickets.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class StaffCli {
    private final ConcertService concertService;
    private final StadiumRepository stadiumRepository;

    public void run(EventStaff eventStaff) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("------- Staff Menu ------");
            System.out.println("1. Manage Concert");
            System.out.println("2. Logout");
            System.out.println("Select an option: ");

            String option = scanner.next();
            switch (option){
                case "1":
                    manageConcert(eventStaff);
                    break;
                case "2":
                    // 처음 로그인 화면으로 되돌아가도록 한다.
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void manageConcert(EventStaff eventStaff){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("------ Manage Concert ------");
            System.out.println("1. View Concert");
            System.out.println("2. Add Concert");
            System.out.println("3. Edit Concert");
            System.out.println("4. Delete Concert");
            System.out.println("5. Back to Main");
            System.out.println("Select an option:");

            try {
                String option = scanner.next();
                switch (option) {
                    case "1":
                        viewConcerts(eventStaff);
                        // 여기 구현하려고 ConcertRepository.java 에 findByStaff 메소드 (리스트) 추가했습니다.
                        // viewConcerts 함수는 아래 쪽에 구현했는데 제대로 했는지 모르겠습니다 ..
                        // 관리자가 관리 중인 concert 의 id, 이름 등을 나타낸다.
                        break;
                    case "2":
                        addConcert(eventStaff);
                        // 관리가가 관리 중인 concert 외에 더 추가한다. 단, 추가하고자 하는 concert 는
                        // concert 테이블에 있는 것이어야 한다. (IF 를 통해서 확인)
                        // 추가하려는 concert 가 이미 다른 스태프에 의해 관리되고 있는지도 확인해야함
                        break;
                    case "3":
                        editConcert(eventStaff);
                        // 관리자가 관리 중인 concert 의 정보를 수정한다.
                        break;
                    case "4":
                        deleteConcert(eventStaff);
                        // 관리자가 관리 중인 concert 의 일부를 지운다. (concert 의 staff 를 null 로)
                        break;
                    case "5":
                        // 메인으로 돌아간다.
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error occured. Please try again");
            }
        }
    }

    private void viewConcerts(EventStaff eventStaff){
        List<Concert> concerts = concertService.findByStaff(eventStaff); // concert list 생성, staff 기준
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if(concerts.isEmpty()){
            System.out.println("There is no managing concerts.");
        } else{
            System.out.println("------ Managing concerts lists ------");
            for(Concert concert: concerts){     // concert ID 와 Name 을 모두 출력
                System.out.println("ID: " + concert.getId() + ", Name: " + concert.getConcertName() +
                        ", Stadium: " + concert.getStadium().getName());

                List<Cast> casts = concert.getCasts();
                for (int i = 1; i <= casts.size(); i++) {
                    Cast cast = casts.get(i - 1);
                    System.out.println("\t Cast #" + i + ": " + cast.getName());
                }

                List<ConcertDate> dates = concert.getDates();
                for (int i = 1; i <= dates.size(); i++) {
                    ConcertDate concertDate = dates.get(i - 1);
                    System.out.println("\t Date #" + i + ": " +
                            concertDate.getStartTime().format(format) + "-" +
                            concertDate.getEndTime().format(format));
                }
            }
        }
    }

    private void addConcert(EventStaff eventStaff){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new concert name: "); // 관리 목록에 추가할 concert name 입력
        String newConcert = scanner.nextLine();

        System.out.println("Enter new concert explanation: "); // 관리 목록에 추가할 concert explanation 입력
        String newExplanation = scanner.nextLine();

        System.out.println("Enter new concert stadium: "); // 관리 목록에 추가할 concert stadium 입력
        String newStadium = scanner.nextLine();

        Stadium stadium = stadiumRepository.findByName(newStadium); // 새로운 이름에 맞는 stadium 객체를 가져옴

        if (stadium == null) {
            System.out.println("Invalid stadium");
            return;
        }

        Concert concert = Concert.builder() // 새로 concert 객체 만들기
                .concertName(newConcert)
                .explaination(newExplanation)
                .staff(eventStaff)
                .stadium(stadium)
                .build();

        System.out.println("The number of concerts (by time): "); // ConcertDate 수 입력
        int concertCount = scanner.nextInt();
        scanner.nextLine(); // consume newline
        List<ConcertDate> concertDates = new ArrayList<>(concertCount);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            for (int i = 1; i <= concertCount; i++) {
                System.out.println("concert #" + i + ": ");
                System.out.println("Start Time (yyyy-MM-dd HH:mm): "); // 시작 시간 입력
                String newStartTime = scanner.nextLine();
                LocalDateTime startTime = LocalDateTime.parse(newStartTime, format);

                System.out.println("End Time (yyyy-MM-dd HH:mm): "); // 종료 시간 입력
                String newEndTime = scanner.nextLine();
                LocalDateTime endTime = LocalDateTime.parse(newEndTime, format);

                concertDates.add(ConcertDate.builder()
                        .concert(concert)
                        .startTime(startTime)
                        .endTime(endTime)
                        .build());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format");
            return;
        }

        System.out.println("The number of casts: "); // Cast 수 입력
        byte castCount = scanner.nextByte();
        scanner.nextLine(); // consume newline

        List<Cast> castList = new ArrayList<>(castCount);
        for (byte i = 1; i <= castCount; i++) {
            System.out.println("Enter the name of cast #" + i + ": ");
            String castName = scanner.nextLine();
            Cast cast = Cast.builder().name(castName).event(concert).seqOrder(i).build();
            castList.add(cast);
        }

        concert.setDates(concertDates);
        concert.setCasts(castList);

        concertService.save(concert);
        System.out.println("------ Concert added to list. ------");
    }

    private void editConcert(EventStaff eventStaff){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the concert to edit:"); // 수정하고자 하는 concert id 입력
        long id = scanner.nextLong();
        scanner.nextLine();

        Concert concert = concertService.findById(id).orElse(null); // id 통해 concert 찾기
        if (concert == null || !concert.getStaff().equals(eventStaff)) { // concert 의 staff 가 아닌 경우도 고려
            System.out.println("Concert not found or there is no access to edit.");
            return;
        }

        // 기존 concert 정보 출력
        System.out.println("------ Current Concert Info ------");
        System.out.println("Stadium: " + concert.getStadium().getName());
        System.out.println("Name: " + concert.getName());
        System.out.println("Concert Name: " + concert.getConcertName());
        System.out.println("Explanation: " + concert.getExplaination());

        // 새로 정보를 입력받아서 그 내용을 concert 데이터베이스에 적용한다.
        System.out.println("Enter new name (If nothing changed, leave blank):"); // 새로운 이름 입력
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            concert.setName(newName);
        }

        System.out.println("Enter new explanation (If nothing changed, leave blank):"); // 새로운 설명 입력
        String newExplanation = scanner.nextLine();
        if (!newExplanation.isBlank()) {
            concert.setExplaination(newExplanation);
        }

        concertService.save(concert);
        System.out.println("------ Concert Updated. ------");
    }

    private void deleteConcert(EventStaff eventStaff){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the concert to delete:"); // 더 이상 관리하지 않고자 하는 concert ID 입력
        long id = scanner.nextLong();

        Concert concert = concertService.findByIdFetchOnlyStaff(id).orElse(null); // concert ID 가 없거나
        if (concert == null || !concert.getStaff().equals(eventStaff)) { // 해당 concert staff 가 본인이 아니라면
            System.out.println("Concert not found or there is no access to delete it.");
            return;
        }

        concert.setStaff(null); // concert 의 staff 필드를 null 로 설정
        concertService.save(concert);
        System.out.println("------ Concert has been removed from management list. ------");
    }
}
