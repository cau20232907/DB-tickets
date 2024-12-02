package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Cast;
import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.entity.EventStaff;
import kr.ac.cau.project.tickets.entity.Stadium;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import kr.ac.cau.project.tickets.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class StaffCli {

    private final ConcertRepository concertRepository;
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
                    // TODO: 처음 로그인 화면으로 되돌아가도록 한다.
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

            String option = scanner.next();
            switch (option){
                case "1":
                    viewConcerts(eventStaff);
                    // 여기 구현하려고 ConcertRepository.java 에 findByStaff 메소드 (리스트) 추가했습니다.
                    // viewConcerts 함수는 아래 쪽에 구현했는데 제대로 했는지 모르겠습니다 ..
                    // TODO: 관리자가 관리 중인 concert 의 id, 이름 등을 나타낸다.
                    break;
                case "2":
                    addConcert(eventStaff);
                    // TODO: 관리가가 관리 중인 concert 외에 더 추가한다. 단, 추가하고자 하는 concert 는
                    // TODO: concert 테이블에 있는 것이어야 한다. (IF 를 통해서 확인)
                    // TODO: 추가하려는 concert 가 이미 다른 스태프에 의해 관리되고 있는지도 확인해야함
                    break;
                case "3":
                    editConcert(eventStaff);
                    // TODO: 관리자가 관리 중인 concert 의 정보를 수정한다.
                    break;
                case "4":
                    deleteConcert(eventStaff);
                    // TODO: 관리자가 관리 중인 concert 의 일부를 지운다. (concert 의 staff 를 null 로)
                    break;
                case "5":
                    // TODO: 메인으로 돌아간다.
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void viewConcerts(EventStaff eventStaff){
        List<Concert> concerts = concertRepository.findByStaff(eventStaff); // concert list 생성, staff 기준

        if(concerts.isEmpty()){
            System.out.println("There is no managing concerts.");
        } else{
            System.out.println("------ Managing concerts lists ------");
            for(Concert concert: concerts){     // concert ID 와 Name 을 모두 출력
                System.out.println("ID: " + concert.getId() + ", Name: " + concert.getConcertName());
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

        Concert concert = Concert.builder() // 새로 concert 객체 만들기
                .concertName(newConcert)
                .explaination(newExplanation)
                .staff(eventStaff)
                .stadium(stadium)
                .build();

        System.out.println("Start Time (yyyy-MM-dd HH:mm): "); // 시작 시간 입력
        String newStartTime = scanner.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(newStartTime);

        System.out.println("End Time (yyyy-MM-dd HH:mm): "); // 종료 시간 입력
        String newEndTime = scanner.nextLine();
        LocalDateTime endTime = LocalDateTime.parse(newEndTime);

        System.out.println("The number of casts: "); // Cast 수 입력
        int castCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Cast> castList = new ArrayList<>();
        for (int i = 1; i <= castCount; i++) {
            System.out.println("Enter the name of cast #" + i + ": ");
            String castName = scanner.nextLine();
            Cast cast = Cast.builder().name(castName).seqOrder((byte) i).build();
            castList.add(cast);
        }

        ConcertDate concertDate = ConcertDate.builder() // ConcertDate 도 함께 생성
                .concert(concert)
                .startTime(startTime)
                .endTime(endTime)
                .build();
        concert.getDates().add(concertDate);

        for (Cast cast : castList) { // Cast 추가 및 연결
            cast.setEvent(concert);
            concert.getCasts().add(cast);
        }

        concertRepository.save(concert);
        System.out.println("------ Concert added to list. ------");
    }

    private void editConcert(EventStaff eventStaff){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the concert to edit:"); // 수정하고자 하는 concert id 입력
        Long id = scanner.nextLong();
        scanner.nextLine();

        Concert concert = concertRepository.findById(id).orElse(null); // id 통해 concert 찾기
        if (concert == null || !concert.getStaff().equals(eventStaff)) { // concert 의 staff 가 아닌 경우도 고려
            System.out.println("Concert not found or there is no access to edit.");
            return;
        }

        // 기존 concert 정보 출력
        System.out.println("------ Current Concert Info ------");
        System.out.println("Stadium: " + (concert.getStadium()));
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

        concertRepository.save(concert);
        System.out.println("------ Concert Updated. ------");
    }

    private void deleteConcert(EventStaff eventStaff){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the concert to delete:"); // 더 이상 관리하지 않고자 하는 concert ID 입력
        Long id = scanner.nextLong();

        Concert concert = concertRepository.findById(id).orElse(null); // concert ID 가 없거나
        if (concert == null || !concert.getStaff().equals(eventStaff)) { // 해당 concert staff 가 본인이 아니라면
            System.out.println("Concert not found or there is no access to delete it.");
            return;
        }

        concert.setStaff(null); // concert 의 staff 필드를 null 로 설정
        concertRepository.save(concert);
        System.out.println("------ Concert has been removed from management list. ------");
    }
}
