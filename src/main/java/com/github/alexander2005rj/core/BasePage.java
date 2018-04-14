package com.github.alexander2005rj.core;

import static com.github.alexander2005rj.core.DriverFactory.createDriver;

import org.openqa.selenium.By;

public class BasePage {
	
	/******** Acessar URL ********/
	
	public void acessarURL( String url ) {
		createDriver().get( url );
	}
	
	/******** Inputs ********/
	
	public void inserir( String id_campo, String texto ) {
		createDriver().findElement( By.id( id_campo ) ).clear();
		createDriver().findElement( By.id( id_campo ) ).sendKeys( "texto" );;
	}
	
	/******** Botões ********/
	
	public void clicarNoBotao( String id_botao ) {
		createDriver().findElement( By.id( id_botao ) ).click();
	}
	
	/******** Links ********/
	
	public void clicarNoLink( By by ) {
		createDriver().findElement( by ).click();
	}
	
	public void clicarNoLink( String link ) {
		clicarNoLink( By.linkText( link ) );
	}
	
	
}
