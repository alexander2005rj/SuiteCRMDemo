package com.github.alexander2005rj.core;

import static com.github.alexander2005rj.core.DriverFactory.createDriver;
import static com.github.alexander2005rj.core.DriverFactory.destroyDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.github.alexander2005rj.pages.LoginPage;


public class BaseTest {
	
	private LoginPage loginPage = new LoginPage();
	
	
	@Rule
	public TestName testName = new TestName();
	
	
	@Before
	public void setUp() {
		loginPage.logar( "will", "will" );
	}
	
	@After
	public void tearDrop() {
		destroyDriver();
	}
	
	
	/*
	@After
	public void finaliza() throws IOException{
		TakesScreenshot screen = (TakesScreenshot) createDriver();
		File arquivo = screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile( arquivo, new File( "target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".png") );
	
		
		if ( Propriedades.FECHAR_BROWSER ) {
			destroyDriver();
		
	}
	*/
}
