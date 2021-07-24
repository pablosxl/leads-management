package br.com.leadsmanagement.mongodb;

public interface MongoConfig {
	/**
	 * Baseado na variável de ambiente: DB_PROTOCOL<br>
	 * Exemplo DOCKERFILE: ENV DB_PROTOCOL=mongodb+srv
	 * @return
	 */
	public String getProtocol();
	/**
	 * Baseado na variável de ambiente: DB_HOST<br>
	 * Exemplo DOCKERFILE: ENV DB_HOST=rshom-8uqla.azure.mongodb.net
	 * @return
	 */
	public String getHost();
	/**
	 * Baseado na variável de ambiente: DB_EXTRA_QUERY_STRING<br>
	 * Exemplo DOCKERFILE: ENV DB_EXTRA_QUERY_STRING=?w=majority
	 * @return
	 */
	public String getExtraQueryString();
	/**
	 * Baseado na variável de ambiente: DB_SSL<br>
	 * Exemplo DOCKERFILE: ENV DB_SSL=true
	 * @return
	 */
	public boolean isSsl();
	/**
	 * Baseado na variável de ambiente: DB_NAME<br>
	 * Exemplo DOCKERFILE: ENV DB_NAME=db_restapi_registered_email
	 * @return
	 */
	public String getDbName();
	/**
	 * Baseado na variável de ambiente: DB_CRUD_USER_NAME<br>
	 * Exemplo DOCKERFILE: ENV DB_CRUD_USER_NAME=UsrRestapiRegisteredEmail
	 * @return
	 */
	public String getDbUserName();
	/**
	 * Baseado na variável de ambiente: DB_CRUD_USER_PASSWORD<br>
	 * Exemplo DOCKERFILE: ENV DB_CRUD_USER_PASSWORD=complinePs2020
	 * @return
	 */
	public String getDbUserPassword();
	/**
	 * Baseado na variável de ambiente: DB_MAX_POOL_SIZE<br>
	 * Exemplo DOCKERFILE: ENV DB_MAX_POOL_SIZE=100
	 * @return
	 */
	public int getMaxPoolSize();
	/**
	 * Baseado na variável de ambiente: DB_WRITE_TIMEOUT<br>
	 * Exemplo DOCKERFILE: ENV DB_WRITE_TIMEOUT=2500
	 * @return
	 */
	public int getWriteTimeout();
	/**
	 * Baseado na variável de ambiente: DB_WRITE_CONCERN<br>
	 * Exemplo DOCKERFILE: ENV DB_WRITE_CONCERN=majority
	 * @return
	 */
	public String getWriteConcern();
	/**
	 * Baseado na variável de ambiente: DB_WRITE_OPERATION_IN_MEMORY<br>
	 * Exemplo DOCKERFILE: ENV DB_WRITE_OPERATION_IN_MEMORY=false
	 * @return
	 */
	public boolean isWriteOperationInMemory();
	/**
	 * Baseado na variável de ambiente: DB_REPLICA_SET<br>
	 * Exemplo DOCKERFILE: ENV DB_REPLICA_SET=rsHom 
	 * @return
	 */
	public String getReplicaSetName();
	/**
	 * Baseado na variável de ambiente: DB_MILLISECONDS_TO_RETRY_CONN<br>
	 * Exemplo DOCKERFILE: ENV DB_MILLISECONDS_TO_RETRY_CONN=60000
	 * @return
	 */
	public int getMilisencondsToRetryConnection();	
	/**
	 * Baseado na variável de ambiente: DB_READ_PREFERENCE<br>
	 * Exemplo DOCKERFILE: ENV DB_READ_PREFERENCE=nearest
	 * @return
	 */
	public String getReadPreference();
	/**
	 * Baseado na variável de ambiente: DB_RETRY_WRITES<br>
	 * Exemplo DOCKERFILE: ENV DB_RETRY_WRITES=false
	 * @return
	 */
	public boolean isRetryWrites();
}
