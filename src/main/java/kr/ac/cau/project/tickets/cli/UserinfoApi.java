package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Userinfo;
import kr.ac.cau.project.tickets.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoApi {
    @Autowired
    private static UserinfoRepository UserinfoRepository;

    public UserinfoApi(UserinfoRepository userinfoRepository){
        UserinfoApi.UserinfoRepository = userinfoRepository;
    }

    static void insert(Userinfo userinfo){
        UserinfoRepository.saveAndFlush(userinfo);
    }
}
