package eu.ditect.ifsms.unstructureddataservice.repository;

import eu.ditect.ifsms.unstructureddataservice.document.SensorDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RapidSensorRepository extends MongoRepository<SensorDocument, String> {
    RapidSensorRepository findByLocalIdentifier(String localIdentifier);
}