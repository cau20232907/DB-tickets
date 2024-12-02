package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.Payment;
import kr.ac.cau.project.tickets.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentApi {
    @Autowired
    private static PaymentRepository PaymentRepository;

    public PaymentApi(PaymentRepository paymentRepository){
        PaymentApi.PaymentRepository = paymentRepository;
    }

    static List<Payment>findPaymentByMember(Member member){
        return PaymentRepository.findByMember(member);
    }

    static void insert(Payment payment){
        PaymentRepository.saveAndFlush(payment);
    }
}
