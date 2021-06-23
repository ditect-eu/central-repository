package eu.ditect.ifsms.unstructureddataservice.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "rapidsensordata")
public class SensorDocument {
    @Id
    private String identifier;
    private String localIdentifier;
    private List<String> data;
}
