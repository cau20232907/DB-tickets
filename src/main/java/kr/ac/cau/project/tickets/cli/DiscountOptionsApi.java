package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.DiscountOptions;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.DiscountOptionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountOptionsApi {
    @Autowired
    private static DiscountOptionsRepository DiscountOptionsRepository;

    public DiscountOptionsApi(DiscountOptionsRepository discountOptionsRepository){
        DiscountOptionsApi.DiscountOptionsRepository = discountOptionsRepository;
    }

    public static List<DiscountOptions> findAllDiscountOptions(){
        return DiscountOptionsRepository.findAll();
    }
}
