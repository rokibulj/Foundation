package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public String getSauceLabsProperty(String key) {
		String value = null;
		Properties prop = loadProperties("saucelabs");
		value = prop.getProperty(key);

		return value;
	}

	public String getProperty(String key) {
		String value = null;
		Properties prop = loadProperties("testRun");
		value = prop.getProperty(key);
		
		if (value == null) {
			String testEnv = prop.getProperty("testEnv");
			prop = loadProperties(testEnv);
			value = prop.getProperty(key);
		}
		return value;
	}

	private Properties loadProperties(String fileName) {
		Properties prop = new Properties();
		String filePath = "./src/main/resources/properties/" + fileName + ".properties";
		try {
			File file = new File(filePath);
			FileInputStream fileStream = new FileInputStream(file);
			prop.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}
}
