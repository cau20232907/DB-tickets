package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.DiscountOptions;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.DiscountOptionsRepository;
import java.util.List;

public class DiscountOptionsApi {
    @Autowired
    private static DiscountOptionsRepository DiscountOptionsRepository;

    static List<DiscountOptions> findAllDiscountOptions(){
        return DiscountOptionsRepository.findAll();
    }
}
