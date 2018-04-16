package com.github.alexander2005rj.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	// ATENÇÃO ==> Tentar trabalhar com HEADLESS antes de enviar
	
	public static WebDriver createDriver() {
		if ( driver == null ) {
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
