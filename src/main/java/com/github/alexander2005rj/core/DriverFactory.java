package com.github.alexander2005rj.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver createDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();;
		return driver;
	}
	
	public static void destroyDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
