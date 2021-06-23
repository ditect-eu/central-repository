package eu.ditect.ifsms.unstructureddataservice.web.dto;

import lombok.Data;

@Data
public class SensorDto {
    private String identifier;
    private String[] data;
}
