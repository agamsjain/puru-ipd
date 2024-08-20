package com.puru.ipd.service;

import com.puru.carbon.entity.SubServiceTransferDTO;
import com.puru.ipd.entity.master.PuruDocumentMaster;
import com.puru.ipd.entity.master.Service;
import com.puru.ipd.repository.PuruDocumentMasterRepository;
import com.puru.ipd.repository.ServiceRepo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Optional;

@org.springframework.stereotype.Service
public class MasterDataService {
    private static final Logger logger = LoggerFactory.getLogger(MasterDataService.class);

    private final VariableFactoryService variableFactoryService;
    private final ServiceRepo serviceRepo;
    private final WebClient webClient;
    private final PuruDocumentMasterRepository puruDocumentMasterRepository;

    public MasterDataService(VariableFactoryService variableFactoryService, ServiceRepo serviceRepo, WebClient webClient, PuruDocumentMasterRepository puruDocumentMasterRepository) {
        this.variableFactoryService = variableFactoryService;
        this.serviceRepo = serviceRepo;
        this.webClient = webClient;
        this.puruDocumentMasterRepository = puruDocumentMasterRepository;
    }

    @Cacheable("getServiceById")
    public Service getServiceById(long id) {
        return serviceRepo.findById(id).get();
    }


//    public PuruResult initPathologyService() {
//        Service[] servicesFromService = fetchServicesFromCentralServer();
//        for (Service serviceFromHAS : servicesFromService) {
//            saveService(serviceFromHAS);
//        }
//        return new PuruResult(true);
//    }




    public Service saveService(Service newService, boolean fromUI) {
        Optional<Service> serviceOptional = serviceRepo.findById(newService.getId());
        Service serviceToSave = null;
        if (serviceOptional.isPresent()) {
            serviceToSave = serviceOptional.get();

            if (fromUI) {
                serviceToSave.setResultType(newService.getResultType());

                //TODO: result option and comment suggestion might come here.

            } else {
                serviceToSave.setName(newService.getName());
                serviceToSave.setDescription(newService.getDescription());
                serviceToSave.setOldSoftId(newService.getOldSoftId());
                serviceToSave.setDocId(newService.getDocId());
                serviceToSave.setsClass(newService.getsClass());
                serviceToSave.setSubServicePresent(newService.isSubServicePresent());
            }
        } else serviceToSave = newService;
        serviceToSave = serviceRepo.save(serviceToSave);
//        updateServiceParametersInInvestigation(serviceToSave);
//        validationService.validateService(serviceToSave.getId());
        return serviceToSave;
    }

//    private void updateServiceParametersInInvestigation(Service serviceToSave) {
//        List<HASConstant.PathologyResultStatus> doNotChangeStatusList = Arrays.asList(CANCEL, APPROVED, REJECTED);
//        Uom uom = serviceToSave.getUom();
//        long uomId = 0;
//        String uomDisplayName = StringUtils.EMPTY;
//        if (uom != null) {
//            uomId = uom.getId();
//            uomDisplayName = uom.getDisplayName();
//        }
//
//        pathologyInvestigationRepository.updateServiceParametersInEligibleInvestigation(serviceToSave.getName(),
//                serviceToSave.getsClass(), serviceToSave.getResultType(), uomId,
//                uomDisplayName, serviceToSave.getDocumentMasterId(),
//                serviceToSave.isSubServicePresent(), serviceToSave.getId(), doNotChangeStatusList);
//    }

//    public PuruResult initPathologySubService() {
//        SubService[] servicesFromService = fetchSubServicesFromCentralServer();
//        for (SubService serviceFromHAS : servicesFromService) {
//            subServiceRepo.save(serviceFromHAS);
//        }
//        return new PuruResult(true);
//    }

//    public Service[] fetchServicesFromCentralServer() {
//        return webClient.get()
//                .uri(variableFactoryService.getPuruHASUrl() + "/fetch-services-internal/" + ServiceType.PTEST)
//                .retrieve()
//                .bodyToMono(Service[].class).block();
//    }

//    public SubService[] fetchSubServicesFromCentralServer() {
//        Class<SubService[]> elementClass = SubService[].class;
//        String fullURL = variableFactoryService.getPuruHASUrl() + "/fetch-subservices-internal/" + ServiceType.PTEST;
//        return webClient.get()
//                .uri(fullURL)
//                .retrieve()
//                .bodyToMono(elementClass).block();
//    }

//    public void deleteSubService(SubServiceTransferDTO subServiceToDelete) {
//        subServiceRepo.deleteById(subServiceToDelete.id());
//    }
//
//    public List<Uom> getUOMList() {
//        return uomRepo.findAll();
//    }
//
//    public List<Service> getAllSubServicesList(long parentServiceId) {
//        return subServiceRepo.findAllSubServiceOfParentServiceById(parentServiceId);
//    }

//    public PuruDocumentMaster insertNewDocumentReport(InsertDocumentReportMasterDTO reportMasterDTO) {
//        PuruDocumentMaster documentMaster = new PuruDocumentMaster(reportMasterDTO.name(), reportMasterDTO.fileName(), "DocumentReportTemplate", "DocumentReportParameterMap", "DocumentReportDataSource");
//        documentMaster = puruDocumentMasterRepository.save(documentMaster);
//        serviceRepo.updateDocumentMasterIdById(documentMaster.getId(), reportMasterDTO.serviceId());
//        return documentMaster;
//    }
}
