package org.ypq.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.queue.info.routing.key}")
    private String infoRoutingKey;

    @Value("${mq.queue.error.routing.key}")
    private String errorRoutingKey;

    public void sendInfo() {
        amqpTemplate.convertAndSend(exchange, infoRoutingKey, new Date());
    }

    public void sendError() {
        amqpTemplate.convertAndSend(exchange, errorRoutingKey, new Date());
    }

}
