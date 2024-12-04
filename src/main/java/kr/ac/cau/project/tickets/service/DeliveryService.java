package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Ticket;
import kr.ac.cau.project.tickets.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public void save(List<Ticket> target, String address) {
        //TODO 프로시저나 함수 생성해서 처리
    }
}