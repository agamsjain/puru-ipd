package com.puru.ipd.service;


import com.puru.config.RabbitMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageBrokerService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageBrokerService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

//    @Autowired
//    private Gson gson;

    public void sendMessage(String qName, Object toSend, Integer msDelay) {
        rabbitTemplate.convertAndSend(RabbitMQQueue.E_HAS, qName, toSend, message -> {
            message.getMessageProperties().setDelay(msDelay);
            return message;
        });
    }

    public void sendMessage(String qName, Object toSend) {
        rabbitTemplate.convertAndSend(qName, toSend);
    }

    public Integer getRMQPropertyValue(String queueName, String propertyString) {
        return (Integer) amqpAdmin.getQueueProperties(queueName).get(propertyString);
    }
}
