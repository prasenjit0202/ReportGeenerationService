package com.assessment.consumer;

import com.assessment.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class KafkaMessageListener {

    @Resource
    TransactionService transactionService;

    @KafkaListener(topics = "${kafka.inbound.to.reportgenerator.topic}", groupId = "${kafka.inbound.to.reportservice.consumergroup}", containerFactory = "kafkaListenerContainerFactory")
    public void kafkaListenerFromRiskForTransactionID(@Payload String message) throws Exception {
        log.info("Received Message " + message); // Better to put this log in debug mode. Currently in info mode just for logging
        transactionService.executeIncomingMessage(message);
    }
}
