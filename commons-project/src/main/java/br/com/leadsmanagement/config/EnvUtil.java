package br.com.leadsmanagement.config;

public abstract class EnvUtil {
	
	private EnvUtil() {
		super();
	}

	/**
	 * 
	 * @param envName
	 * @return
	 */
	public static String envString(final String envName) {
		try {
			return System.getenv(envName);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param envName
	 * @return
	 */
	public static String[] envStringArray(final String envName) {
		try {
			return System.getenv(envName).replaceAll(" ", "").split(",");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param envName
	 * @return
	 */
	public static int envInt(final String envName) {
		try {
			return Integer.parseInt(System.getenv(envName));
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 
	 * @param envName
	 * @return
	 */
	public static boolean envBoolean(final String envName) {
		try {
			return Boolean.parseBoolean(System.getenv(envName));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param envName
	 * @return
	 */
	public static long envLong(final String envName) {
		try {
			return Long.parseLong(System.getenv(envName));
		} catch (Exception e) {
			return -1;
		}
	}
}
