package br.com.leadsmanagement.mongodb;

import org.apache.commons.lang3.StringUtils;

public abstract class MongoConfiguration {
private static final String CREDENTIALS_TEMPLATE = "%s:%s@";
	
	private static final String REPLICASET_RELATED_TEMPLATE = 
			"&replicaSet=%s"
			+ "&retryWrites=%s" 
			+ "&w=%s" 
			+ "&j=%s" 
			+ "&readPreference=%s";

	public static final String CONNECTION_STRING_TEMPLATE = "%s://%s%s/%s" 
			+ "?"
			+ "maxPoolSize=%s"
			+ "&wtimeoutMS=%s" 
			+ "&ssl=%s" 
			
			+ "%s" // Replicaset Related
			
			+ "%s" // Extra Query String
			;
	
    private MongoConfiguration() {
    	super();
    }

	public static String getMongoConnectionUrl(final MongoConfig mongoConfig) {
        final String connectionUrl = 
        		String.format(CONNECTION_STRING_TEMPLATE,
        				mongoConfig.getProtocol(),
        				getCredentials(mongoConfig),
        				mongoConfig.getHost(), 
        				mongoConfig.getDbName(),
        				mongoConfig.getMaxPoolSize(),
        				mongoConfig.getWriteTimeout(),
                        mongoConfig.isSsl(),
        				
        				getReplicasetRelated(mongoConfig),
                        
                        mongoConfig.getExtraQueryString());

        return connectionUrl;
    }
	
	private static String getCredentials(final MongoConfig mongoConfig) {
		String credentials = "";
		
		if(StringUtils.isNotBlank(mongoConfig.getDbUserName())
				|| StringUtils.isNotBlank(mongoConfig.getDbUserPassword())) {
			credentials = String.format(CREDENTIALS_TEMPLATE, 
					mongoConfig.getDbUserName(),
					mongoConfig.getDbUserPassword());
		}
		
		return credentials;
	}
	
	private static final String getReplicasetRelated(final MongoConfig mongoConfig) {
		String replicasetRelated = "";
		
		if(StringUtils.isNotBlank(mongoConfig.getReplicaSetName())) {
			replicasetRelated = String.format(REPLICASET_RELATED_TEMPLATE, 
					mongoConfig.getReplicaSetName(),
    				mongoConfig.isRetryWrites(),
                    mongoConfig.getWriteConcern(),
                    mongoConfig.isWriteOperationInMemory(),
                    mongoConfig.getReadPreference());
		}
		
		return replicasetRelated;
	}
}
