/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

/**
 * Configuration :: It reads the configuration file (P2EConfig.ini) only once at the application start up 
 * and puts the data in to a map as key-value pairs.
 *
 */

package com.accelerators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Configuration {

	public static HashMap<String, String> configItems = new HashMap<String, String>();
	private static BufferedReader bufferedReader;
	
	/**
	 * GetProperty :: It returns the mapped value based on the key.
	 * @param key
	 * @return
	 */
	public static String GetProperty(String key) {
		
		String dataValue = null;
	
		if (configItems.containsKey(key)) {
			dataValue = configItems.get(key);
		}
		return dataValue;
	}

	/**
	 * PutProperty :: It does the key-value entry into configItems map.
	 * @param key
	 * @param value
	 */
	public static void PutProperty(String key, String value) {
		
		configItems.put(key, value);
	}

//	/**
//	 * loadConfiguration :: It reads the configuration file (P2EConfig.ini) only once at the application start up and puts the data in to a map as key-value pairs.
//	 * @throws IOException
//	 */
//	public static void loadConfiguration() throws IOException {
//		
//		String configFilePath = GetProperty("ConfigFilePath") +File.separator +"Config.ini";
//		
////		String configFilePath = GetProperty("C:\\Users\\e001236\\eclipse-workspace\\FrameWork_POC\\ApplicationConfig.properties");
//		
//		if (configItems.size() <= 1) {
//			String splitBy = "=";
//			bufferedReader = new BufferedReader(new FileReader(configFilePath));
//			String line = bufferedReader.readLine();
//			while (line != null) {
//				String[] columnData = line.split(splitBy);
//				configItems.put(columnData[0], columnData[1]);
//				line = bufferedReader.readLine();
//			}
//		}
//	}
	
}
