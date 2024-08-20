package com.puru.ipd.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puru.carbon.entity.IntraPuruMasterDataTransferObject;
import com.puru.config.RabbitMQQueue;
import com.puru.ipd.entity.master.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@org.springframework.stereotype.Service
public class RabbitMQListenerService {

    private final ObjectMapper objectMapper;
    private final MasterDataService masterDataService;

    public RabbitMQListenerService(ObjectMapper objectMapper, MasterDataService masterDataService) {
        this.objectMapper = objectMapper;
        this.masterDataService = masterDataService;
    }


    @RabbitListener(queues = RabbitMQQueue.INTRA_PURU_MASTER_DATA_TRANSFER_TO_IPD)
    public void receiveOrder(IntraPuruMasterDataTransferObject message) throws JsonProcessingException {
        System.out.println("IPD Master Data received: " + message);
        switch (message.mode()) {
            case SAVE_SERVICE:
            case UPDATE_SERVICE:
                Service service = objectMapper.readValue(message.entityInString(), Service.class);
                masterDataService.saveService(service, false);
                break;
            case DEPARTMENT:
                break;
        }
    }
}
