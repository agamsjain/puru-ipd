package com.puru.config;

public interface RabbitMQQueue {
    String E_HAS = "e_puru_has";

    String Q_PATIENT_COMMUNICATION = "handle_patient_communication";
    String FROM_WHATSAPP_WEBHOOK = "from_whatsapp_webhook";
    String HANDLE_WHATSAPP_API_RESPONSE = "handle_whatsapp_api_response";


    String Q_UPLOAD_HAS_DOCUMENT_TO_CLOUD = "upload_has_document_to_cloud";

    String TO_RT_OBJECT_TRANSFER = "to_rt_object_transfer";
    String FROM_RT_OBJECT_TRANSFER = "from_rt_object_transfer";

    String INTRA_PURU_MASTER_DATA_TRANSFER_TO_IPD = "intra_puru_master_data_transfer_to_ipd";


}
