package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Userinfo;
import kr.ac.cau.project.tickets.repository.NativeQueryRepository;
import kr.ac.cau.project.tickets.repository.UserinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserinfoService {
    private final UserinfoRepository userinfoRepository;
    private final NativeQueryRepository nativeQueryRepository;

    public Userinfo login(String username, String password) {
        Optional<Long> resultName = nativeQueryRepository.login(username, password);
        return resultName.map(s -> userinfoRepository.findById(s).get()).orElse(null);
    }

    public void signin(String username, String password) {
        nativeQueryRepository.signin(username, password);
    }

    @Transactional(readOnly = true)
    public boolean ifUsernameUsable(String username) {
        return userinfoRepository.findByUsername(username).isEmpty();
    }
}