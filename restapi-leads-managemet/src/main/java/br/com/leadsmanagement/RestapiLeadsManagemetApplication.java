package br.com.leadsmanagement;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
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
import br.com.leadsmanagement.mongodb.MongoProperties;

@EnableWebFlux
@SpringBootApplication
@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoRepositoriesAutoConfiguration .class,MongoDataAutoConfiguration.class})
@EnableReactiveMongoRepositories
public class RestapiLeadsManagemetApplication {

	public static void main(String[] args) {
		Env.init();
		
		Locale.setDefault(new Locale("pt", "BR"));
		System.setProperty("file.encoding", "UTF-8");
		
		//MongoProperties mongoProperties = new MongoProperties("mongodb://UsrShippetsApi:shippets.2021@rshom-shard-00-01.zhdgo.mongodb.net:27017,rshom-shard-00-00.zhdgo.mongodb.net:27017,rshom-shard-00-02.zhdgo.mongodb.net:27017/db_shippets_service_api");
		
		SpringApplication.run(RestapiLeadsManagemetApplication.class, args);
	}
	
	
	
	@Bean
	@Scope("singleton")
	public Env env() {
		return Env.getInstance();
	}
	
	/*
	  @Override protected String getDatabaseName() { 
		  // TODO Auto-generated method stub 
		  return Env.getInstance().getMongoConfig().getDbName(); 
	  }
	  
	  @Override
	  @Bean 
	  public MongoClient reactiveMongoClient() {
		  // TODO Auto-generated method stub 
		  MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
				  .applyConnectionString( new ConnectionString("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false")) 
				  .streamFactoryFactory(NettyStreamFactoryFactory.builder().build())
				  .build());
	  
		  return mongoClient; 
	  
	  }*/
	  
	 
	 
	
}
