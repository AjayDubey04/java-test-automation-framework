package com.eva.TrackNinja.basetests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TrackNinjaBaseClass {

	protected AppiumDriver<MobileElement> driver;

	@BeforeSuite
	public void launchTrackNinjaApp() throws MalformedURLException, InterruptedException {

		// Set the Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android"); // Set your device's platform Name
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); // Set your device's platform version
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 5"); // Set your device's name
		capabilities.setCapability(MobileCapabilityType.APP, "D:/app.apk"); // Set your app's package name
		capabilities.setCapability(MobileCapabilityType.UDID, "f4d88ca3"); // Set your app's main activity

		// Specify Appium server URL
		URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
		 
		Thread.sleep(4000);
		 
		// Initialize the AppiumDriver
		driver = new AndroidDriver<MobileElement>(appiumServerURL, capabilities);

	}
	
	
	@Test
	public void tc001() {
//		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.trackninja:id/sign_in_button\"]")).click();
		System.out.println("Hello Appium");
		
	}
	

	/*
	 * @AfterSuite public void closeApp() { // Close the application session //
	 * driver.quit(); }
	 */

}
