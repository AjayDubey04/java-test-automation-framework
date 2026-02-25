package com.example.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

	private Properties properties;

	public ReadConfig(String filePath) {
		this.properties = loadProperties(filePath);
	}

	private Properties loadProperties(String filePath) {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream("src\\test\\resources\\config\\"+filePath+".properties")) {
			prop.load(input);
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	
	public String getApplicationURL() {
		String url=properties.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String username=properties.getProperty("UserName");
		return username;
	}
	
	public String getPassword() {
		String username=properties.getProperty("Password");
		return username;
	}
	
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	
	// You can add more methods as needed
	
	public static void main(String[] args) {
		// Example usage:
		ReadConfig propertyReader = new ReadConfig("config");
		String username = propertyReader.getProperty("username");
		String password = propertyReader.getProperty("password");

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
}


