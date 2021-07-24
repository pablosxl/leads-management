package br.com.leadsmanagement;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import br.com.leadsmanagement.config.Env;
import br.com.leadsmanagement.mongodb.MongoConfiguration;

@EnableWebFlux
@SpringBootApplication
@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
@EnableReactiveMongoRepositories
public class RestapiLeadsManagemetApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		Env.init();
		SpringApplication.run(RestapiLeadsManagemetApplication.class, args);
		
		Locale.setDefault(new Locale("pt", "BR"));
		System.setProperty("file.encoding", "UTF-8");
		
		
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return Env.getInstance().getMongoConfig().getDbName();
	}

	@Override
	@Bean
	public MongoClient reactiveMongoClient() {
		// TODO Auto-generated method stub
		MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
	            .applyConnectionString(
	            		new ConnectionString(
	            				MongoConfiguration.getMongoConnectionUrl(Env.getInstance().getMongoConfig())))
	            .streamFactoryFactory(NettyStreamFactoryFactory.builder().build())
	            .build());

	    return mongoClient;
	}
	
}
