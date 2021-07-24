package br.com.leadsmanagement.mongodb;

public class MongoConfigImpl implements MongoConfig{
	
	public static final String DB_PROTOCOL = "DB_PROTOCOL";
	public static final String DB_HOST = "DB_HOST";
	public static final String DB_EXTRA_QUERY_STRING = "DB_EXTRA_QUERY_STRING";
	public static final String DB_SSL = "DB_SSL";
	public static final String DB_NAME = "DB_NAME";
	public static final String DB_CRUD_USER_NAME = "DB_CRUD_USER_NAME";
	public static final String DB_CRUD_USER_PASSWORD = "DB_CRUD_USER_PASSWORD";
	public static final String DB_MAX_POOL_SIZE = "DB_MAX_POOL_SIZE";
	public static final String DB_WRITE_TIMEOUT = "DB_WRITE_TIMEOUT";
	public static final String DB_WRITE_CONCERN = "DB_WRITE_CONCERN";
	public static final String DB_WRITE_OPERATION_IN_MEMORY = "DB_WRITE_OPERATION_IN_MEMORY";
	public static final String DB_REPLICA_SET = "DB_REPLICA_SET";
	public static final String DB_MILLISECONDS_TO_RETRY_CONN = "DB_MILLISECONDS_TO_RETRY_CONN";
	public static final String DB_READ_PREFERENCE = "DB_READ_PREFERENCE";
	public static final String DB_RETRY_WRITES = "DB_RETRY_WRITES";
	
	private String protocol;
	private String host;
	private String extraQueryString;
	private boolean ssl;
	private String dbName;
	private String dbUserName;
	private String dbUserPassword;
	private int maxPoolSize;
	private int writeTimeout;
	private String writeConcern;
	private boolean writeOperationInMemory;
	private String replicaSetName;
	private int milisencondsToRetryConnection;
	private String readPreference;
	private boolean retryWrites;
	
	/**
	 * 
	 * @param protocol
	 * @param host
	 * @param extraQueryString
	 * @param ssl
	 * @param dbName
	 * @param dbUserName
	 * @param dbUserPassword
	 * @param maxPoolSize
	 * @param writeTimeout
	 * @param writeConcern
	 * @param writeOperationInMemory
	 * @param replicaSetName
	 * @param milisencondsToRetryConnection
	 * @param readPreference
	 * @param retryWrites
	 */
	public MongoConfigImpl(String protocol, String host, String extraQueryString, boolean ssl, String dbName,
			String dbUserName, String dbUserPassword, int maxPoolSize, int writeTimeout, String writeConcern,
			boolean writeOperationInMemory, String replicaSetName, int milisencondsToRetryConnection,
			final String readPreference, final boolean retryWrites) {
		super();
		this.protocol = protocol;
		this.host = host;
		this.extraQueryString = extraQueryString;
		this.ssl = ssl;
		this.dbName = dbName;
		this.dbUserName = dbUserName;
		this.dbUserPassword = dbUserPassword;
		this.maxPoolSize = maxPoolSize;
		this.writeTimeout = writeTimeout;
		this.writeConcern = writeConcern;
		this.writeOperationInMemory = writeOperationInMemory;
		this.replicaSetName = replicaSetName;
		this.milisencondsToRetryConnection = milisencondsToRetryConnection;
		this.readPreference = readPreference;
		this.retryWrites = retryWrites;
	}
	
	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return this.protocol;
	}
	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return this.host;
	}
	@Override
	public String getExtraQueryString() {
		// TODO Auto-generated method stub
		return this.extraQueryString;
	}
	@Override
	public boolean isSsl() {
		// TODO Auto-generated method stub
		return this.ssl;
	}
	@Override
	public String getDbName() {
		// TODO Auto-generated method stub
		return this.dbName;
	}
	@Override
	public String getDbUserName() {
		// TODO Auto-generated method stub
		return this.dbUserName;
	}
	@Override
	public String getDbUserPassword() {
		// TODO Auto-generated method stub
		return this.dbUserPassword;
	}
	@Override
	public int getMaxPoolSize() {
		// TODO Auto-generated method stub
		return this.maxPoolSize;
	}
	@Override
	public int getWriteTimeout() {
		// TODO Auto-generated method stub
		return this.writeTimeout;
	}
	@Override
	public String getWriteConcern() {
		// TODO Auto-generated method stub
		return this.writeConcern;
	}
	@Override
	public boolean isWriteOperationInMemory() {
		// TODO Auto-generated method stub
		return this.writeOperationInMemory;
	}
	@Override
	public String getReplicaSetName() {
		// TODO Auto-generated method stub
		return this.replicaSetName;
	}
	@Override
	public int getMilisencondsToRetryConnection() {
		// TODO Auto-generated method stub
		return this.milisencondsToRetryConnection;
	}
	@Override
	public String getReadPreference() {
		// TODO Auto-generated method stub
		return this.readPreference;
	}
	@Override
	public boolean isRetryWrites() {
		// TODO Auto-generated method stub
		return this.retryWrites;
	}
}
