package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.TransactionQueue;
import kr.ac.cau.project.tickets.repository.TransactionQueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionQueueService {
    private final TransactionQueueRepository transactionQueueRepository;

    public void saveAll(List<TransactionQueue> transactionQueues) {
        transactionQueues.forEach(data->data.setTime(LocalDateTime.now()));
        transactionQueueRepository.saveAll(transactionQueues);
    }

    public void update() {
        //TODO 업데이트 로직 구현
    }
}