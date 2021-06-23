package eu.ditect.ifsms.unstructureddataservice.service;

import eu.ditect.ifsms.unstructureddataservice.document.SensorDocument;
import eu.ditect.ifsms.unstructureddataservice.repository.RapidSensorRepository;
import eu.ditect.ifsms.unstructureddataservice.web.dto.SensorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class KafkaConsumerService {
    private RapidSensorRepository rapidSensorRepository;

    public KafkaConsumerService(RapidSensorRepository rapidSensorRepository) {
        this.rapidSensorRepository = rapidSensorRepository;
    }

    @KafkaListener(topics = "sensordata", groupId = "sensordata")
    public void listenGroupSensorData(SensorDto sensorDto) {
        log.info("incoming sensorDto: {}", sensorDto);
        SensorDocument sensorDocument = new SensorDocument();
        sensorDocument.setLocalIdentifier(sensorDto.getIdentifier());
        sensorDocument.setData(Arrays.asList(sensorDto.getData()));
        updateSensorDocument(sensorDocument);
    }

    public SensorDocument updateSensorDocument(SensorDocument document) {
        List<SensorDocument> all = rapidSensorRepository.findAll();
        log.info("all: {}", all);
        return rapidSensorRepository.save(document);
    }
}
