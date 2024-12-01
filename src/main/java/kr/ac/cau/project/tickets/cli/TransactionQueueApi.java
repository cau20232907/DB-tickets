package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.TransactionQueue;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.TransactionQueueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionQueueApi {
    @Autowired
    private static TransactionQueueRepository TransactionQueueRepository;

    public TransactionQueueApi(TransactionQueueRepository transactionQueueRepository){
        TransactionQueueApi.TransactionQueueRepository = transactionQueueRepository;
    }

    static List<TransactionQueue> findAllTransactionQueue(){
        return TransactionQueueRepository.findAll();
    }

    static void insert(TransactionQueue tuple){
        TransactionQueueRepository.saveAndFlush(tuple); //saveAndFlush??
    }
}
