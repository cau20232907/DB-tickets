package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Delivery;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import kr.ac.cau.project.tickets.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryApi {
    @Autowired
    private static DeliveryRepository DeliveryRepository;

    public DeliveryApi(DeliveryRepository deliveryRepository){
        DeliveryApi.DeliveryRepository = deliveryRepository;
    }

    static void insert(Delivery delivery){
        DeliveryRepository.saveAndFlush(delivery); //saveAndFlush??
    }
}
