package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Delivery;
import kr.ac.cau.project.tickets.entity.Ticket;
import kr.ac.cau.project.tickets.repository.DeliveryRepository;
import kr.ac.cau.project.tickets.repository.NativeQueryRepository;
import kr.ac.cau.project.tickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final NativeQueryRepository nativeQueryRepository;
    private final TicketRepository ticketRepository;

    public void save(List<Ticket> target, String address) {
        //귀찮아서 여기서 해결
        Delivery delivery = Delivery.builder()
                .arrivalAddress(address)
                .deliveryCompany("company")
                .deliveryCode(UUID.randomUUID().toString())
                .build();
        deliveryRepository.save(delivery);
        List<Ticket> ticketsInManage =
                ticketRepository.findAllById(target.stream().map(Ticket::getId).toList());
        ticketsInManage.forEach(ticket -> {
            ticket.setIsOnline(false);
            ticket.setDelivery(delivery);
        });
        ticketRepository.saveAll(ticketsInManage);

    }
}