package com.hunter.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author liuheng
 * @Description: TODO
 * @date 2020/1/2 15:45
 */
@Component
public class KafkaReceiver {

    private Logger log = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init() {
        log.info("start success");
    }

    @KafkaListener(topics = {"hunter.tbl_order", "hunter.tbl_order-0", "example", "example-0"})
    public void listen0(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("0--- topic->{} partition->{} = {}", record.topic(), record.partition(), message);
        }
    }
}
