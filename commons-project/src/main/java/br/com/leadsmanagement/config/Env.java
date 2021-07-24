package br.com.leadsmanagement.config;



import static br.com.leadsmanagement.config.EnvUtil.envString;
import static br.com.leadsmanagement.config.EnvUtil.envBoolean;
import static br.com.leadsmanagement.config.EnvUtil.envInt;
import static br.com.leadsmanagement.config.EnvUtil.envLong;
import static br.com.leadsmanagement.config.EnvUtil.envStringArray;

import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_CRUD_USER_NAME;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_CRUD_USER_PASSWORD;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_EXTRA_QUERY_STRING;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_HOST;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_MAX_POOL_SIZE;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_MILLISECONDS_TO_RETRY_CONN;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_NAME;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_PROTOCOL;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_READ_PREFERENCE;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_REPLICA_SET;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_RETRY_WRITES;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_SSL;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_WRITE_CONCERN;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_WRITE_OPERATION_IN_MEMORY;
import static br.com.leadsmanagement.mongodb.MongoConfigImpl.DB_WRITE_TIMEOUT;

import br.com.leadsmanagement.mongodb.MongoConfig;
import br.com.leadsmanagement.mongodb.MongoConfigImpl;

public final class Env {
	
	private static final Env SINGLETON = new Env();
	private static final String APPLICATION_ENV = "APPLICATION_ENV";
	private static final String APPLICATION_NAME = "APPLICATION_NAME";
	private static final String PIPE_DRIVE_BASE_URL = "PIPE_DRIVE_BASE_URL";
	private static final String PIPE_DRIVE_API_TOKEN = "PIPE_DRIVE_API_TOKEN";
	
	private String applicationEnv = null;
	private String applicationName = null;
	private MongoConfig mongoConfig = null;
	private String pipeDriveBaseUrl = null;
	private String pipeDriveApiToken = null;
	
	private Env() {
		super();
	}
	
	public static void init() {
		if(SINGLETON.applicationEnv == null) {
			SINGLETON.applicationEnv = envString(APPLICATION_ENV);
		}
		
		if(SINGLETON.applicationName == null) {
			SINGLETON.applicationName = envString(APPLICATION_NAME);
		}
		
		if(SINGLETON.mongoConfig == null) {
			SINGLETON.mongoConfig = new MongoConfigImpl(envString(DB_PROTOCOL), envString(DB_HOST),
					envString(DB_EXTRA_QUERY_STRING), envBoolean(DB_SSL), envString(DB_NAME),
					envString(DB_CRUD_USER_NAME), envString(DB_CRUD_USER_PASSWORD), envInt(DB_MAX_POOL_SIZE),
					envInt(DB_WRITE_TIMEOUT), envString(DB_WRITE_CONCERN), envBoolean(DB_WRITE_OPERATION_IN_MEMORY),
					envString(DB_REPLICA_SET), envInt(DB_MILLISECONDS_TO_RETRY_CONN), envString(DB_READ_PREFERENCE),
					envBoolean(DB_RETRY_WRITES));
		}
		
		if(SINGLETON.pipeDriveBaseUrl == null) {
			SINGLETON.pipeDriveBaseUrl = envString(PIPE_DRIVE_BASE_URL);
		}
		
		if(SINGLETON.pipeDriveApiToken == null) {
			SINGLETON.pipeDriveApiToken = envString(PIPE_DRIVE_API_TOKEN);
		}
	}
	
	public static Env getInstance() {
		return SINGLETON;
	}
	
	public MongoConfig getMongoConfig() {
		return this.mongoConfig;
	}
	
	public String getPipeDriveBaseUrl() {
		return this.pipeDriveBaseUrl;
	}
	
	public String getPipeDriveApiToken() {
		return this.pipeDriveApiToken;
	}
	
}
