package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Userinfo;
import kr.ac.cau.project.tickets.entity.UserinfoLoginRecord;
import kr.ac.cau.project.tickets.repository.NativeQueryRepository;
import kr.ac.cau.project.tickets.repository.UserinfoLoginRecordRepository;
import kr.ac.cau.project.tickets.repository.UserinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserinfoService {
    private final UserinfoRepository userinfoRepository;
    private final NativeQueryRepository nativeQueryRepository;
    private final UserinfoLoginRecordRepository userinfoLoginRecordRepository;

    public Userinfo login(String username, String password) {
        Optional<Long> resultName = nativeQueryRepository.login(username, password);
        return resultName.map(s -> {
            Userinfo userinfo = userinfoRepository.findById(s).get();
            userinfoLoginRecordRepository.save(UserinfoLoginRecord.builder()
                    .userinfo(userinfo)
                    .time(LocalDateTime.now())
                    .build());
            return userinfo;
        }).orElse(null);
    }

    public void signin(String username, String password) {
        nativeQueryRepository.signin(username, password);
    }

    @Transactional(readOnly = true)
    public boolean ifUsernameUsable(String username) {
        return userinfoRepository.findByUsername(username).isEmpty();
    }
}