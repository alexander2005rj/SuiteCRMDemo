package com.github.alexander2005rj.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver createDriver() {
		if ( driver == null ) {
			/*
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("headless");
		    options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options); 
			*/
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();;
		}
		return driver;
	}
	
	public static void destroyDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
