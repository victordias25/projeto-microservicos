package br.com.concessionaria.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    private static final Logger logger = LoggerFactory.getLogger(MensagemService.class);
    @Value("${topic.concessionaria}")
    private String topicConcessionaria;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(message);
        this.kafkaTemplate.send(topicConcessionaria, message);
    }
}