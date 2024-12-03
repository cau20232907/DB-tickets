package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.DiscountOptions;
import kr.ac.cau.project.tickets.repository.DiscountOptionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiscountOptionsService {
    private final DiscountOptionsRepository discountOptionsRepository;

    public List<DiscountOptions> findAll() {
        return discountOptionsRepository.findAll();
    }
}