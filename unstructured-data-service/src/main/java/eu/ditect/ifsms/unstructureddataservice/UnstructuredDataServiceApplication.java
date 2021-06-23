package eu.ditect.ifsms.unstructureddataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class UnstructuredDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnstructuredDataServiceApplication.class, args);
	}

}
