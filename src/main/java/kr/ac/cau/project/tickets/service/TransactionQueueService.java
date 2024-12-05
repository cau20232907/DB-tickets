package kr.ac.cau.project.tickets.service;

import jakarta.annotation.PostConstruct;
import kr.ac.cau.project.tickets.entity.TransactionQueue;
import kr.ac.cau.project.tickets.repository.NativeQueryRepository;
import kr.ac.cau.project.tickets.repository.TransactionQueueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class TransactionQueueService {
    private final TransactionQueueRepository transactionQueueRepository;
    private final NativeQueryRepository nativeQueryRepository;

    private final Timer updateTimer;

    public TransactionQueueService(TransactionQueueRepository transactionQueueRepository,
                                   NativeQueryRepository nativeQueryRepository) {
        this.transactionQueueRepository = transactionQueueRepository;
        this.nativeQueryRepository = nativeQueryRepository;
        this.updateTimer=
                new Timer(5000, new ActionListener() {
                    /**
                     * Invoked when an action occurs.
                     *
                     * @param e the event to be processed
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        update();
                    }
                });
    }

    @PostConstruct
    public void init() {
        updateTimer.start();
    }

    public void saveAll(List<TransactionQueue> transactionQueues) {
        transactionQueues.forEach(data->data.setTime(LocalDateTime.now()));
        transactionQueueRepository.saveAll(transactionQueues);
    }

    public void update() {
//        log.info("update Queue");
        nativeQueryRepository.processTransactionQueue();
        updateTimer.start();
//        log.info("update Queue finished");
    }
}