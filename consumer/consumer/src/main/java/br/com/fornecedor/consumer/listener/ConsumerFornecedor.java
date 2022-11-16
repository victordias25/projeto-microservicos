package br.com.fornecedor.consumer.listener;

import br.com.fornecedor.consumer.controller.service.ConsultaDadosParaFaturar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerFornecedor {

    private final Logger logger = LoggerFactory.getLogger(ConsumerFornecedor.class);

    @KafkaListener(topics = "${topic.concessionaria}", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format(message));
        String numeroChassi = message.substring(23, message.length() - 3);
        ConsultaDadosParaFaturar consultaDadosParaFaturar = new ConsultaDadosParaFaturar();
        consultaDadosParaFaturar.consultaDadosParaFaturar(numeroChassi);
    }
}