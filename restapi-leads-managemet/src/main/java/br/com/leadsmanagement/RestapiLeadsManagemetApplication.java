package br.com.leadsmanagement;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
@EnableReactiveMongoRepositories
public class RestapiLeadsManagemetApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiLeadsManagemetApplication.class, args);
		
		Locale.setDefault(new Locale("pt", "BR"));
		System.setProperty("file.encoding", "UTF-8");
	}

}
