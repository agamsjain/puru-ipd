package com.puru.ipd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VariableFactoryService {

    private static Logger logger = LoggerFactory.getLogger(VariableFactoryService.class);

    private String puruDataRootDir;
    private String serverHttpPath;
    private String hospitalNameEnglish;
    private String hospitalLine2English;
    private String hospitalLine3English;
    private String hospitalRegNo;
    private boolean isProd;
    private String hospitalShortName;
    private String ppinBarcodePrefix;
    private String pathologyBarcodePrefix;
    private String puruPublicBucket;

    public VariableFactoryService(
            @Value("${puru.data.root.dir}") String puruDataRootDir,
            @Value("${puru.server.ip}") String serverIp,
            @Value("${puru.prod}") String isProdString,
            @Value("${puru.ins.name}") String hospitalShortName,
            @Value("${puru.hospital.name.en}") String hospitalNameEnglish,
            @Value("${puru.hospital.line2.en}") String hospitalLine2English,
            @Value("${puru.hospital.line3.en}") String hospitalLine3English,
            @Value("${puru.hospital.reg.no:SAMPLE_REG_NO}") String hospitalRegNo,
            @Value("${puru.employee.prefix}") String employeePrefix,
            @Value("${puru.barcode.prefix.ppin}") String ppinBarcodePrefix,
            @Value("${puru.barcode.prefix.pathology}") String pathologyBarcodePrefix,
            @Value("${puru.public.bucket:puru-public}") String puruPublicBucket
    ) {
        this.hospitalRegNo = hospitalRegNo;


        this.puruDataRootDir = puruDataRootDir;
        this.serverHttpPath = "http://" + serverIp + ":81";
        this.hospitalShortName = hospitalShortName;
        System.setProperty("puru.ins.name", hospitalShortName);
        this.isProd = "1".equals(isProdString);
        this.hospitalNameEnglish = hospitalNameEnglish;
        this.hospitalLine2English = hospitalLine2English;
        this.hospitalLine3English = hospitalLine3English;
        this.ppinBarcodePrefix = ppinBarcodePrefix;
        this.pathologyBarcodePrefix = pathologyBarcodePrefix;
        this.puruPublicBucket = puruPublicBucket;

    }

    public String getServerHttpPath() {
        return serverHttpPath;
    }

    public String getPuruDataRootDir() {
        return puruDataRootDir;
    }

    public String getFolderNameForTodaysReport() {
        String patternForFolder = "ddMMyyyy";
        SimpleDateFormat simpleDateFormatForFolder = new SimpleDateFormat(patternForFolder);
        return simpleDateFormatForFolder.format(new Date());
    }


    public String getHospitalNameEnglish() {
        return hospitalNameEnglish;
    }

    public String getHospitalLine2English() {
        return hospitalLine2English;
    }

    public boolean isProd() {
        return isProd;
    }

    public String getHospitalShortName() {
        return hospitalShortName;
    }

    public String getPpinBarcodePrefix() {
        return ppinBarcodePrefix;
    }

    public void setPpinBarcodePrefix(String ppinBarcodePrefix) {
        this.ppinBarcodePrefix = ppinBarcodePrefix;
    }

    public String getPathologyBarcodePrefix() {
        return pathologyBarcodePrefix;
    }

    public void setPathologyBarcodePrefix(String pathologyBarcodePrefix) {
        this.pathologyBarcodePrefix = pathologyBarcodePrefix;
    }

    public String getHospitalLine3English() {
        return hospitalLine3English;
    }

    public String getPuruPublicBucket() {
        return puruPublicBucket;
    }

    public String getHospitalRegNo() {
        return hospitalRegNo;
    }
}
