package com.github.alexander2005rj.core;

import static com.github.alexander2005rj.core.DriverFactory.createDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/******** Acessar URL ********/
	
	public void acessarURL( String url ) {
		comecarEsperaImplicita( 8 );
		createDriver().get( url );
		terminarEsperaImplicita();
	}
	
	
	/******** Inputs e Textareas ********/
	
	public void inserir( String id_campo, String texto ) {
		//createDriver().findElement( By.id( id_campo ) ).clear();
		createDriver().findElement( By.id( id_campo ) ).sendKeys( texto );;
	}
	
	
	/******** Botões ********/
	
	public void clicarNoBotao( By by ) {
		createDriver().findElement( by ).click();
	}
	
	public void clicarNoBotao( String id_botao ) {
		clicarNoBotao( By.id( id_botao ) );
	}
	
	
	/******** Links ********/
	
	public void clicarNoLink( By by ) {
		createDriver().findElement( by ).click();
	}
	
	public void clicarNoLink( String link ) {
		clicarNoLink( By.linkText( link ) );
	}
	
	public void clicarNoLinkPorId( String id_link ) {
		clicarNoLink( By.id( id_link ) );
	}
	
	
	/******** Combos ********/
	
	public void selecionarOpcao( String id_combo, String valorCombo ) {
		WebElement element = createDriver().findElement( By.id( id_combo ) );
		Select combo = new Select( element );
		combo.selectByVisibleText( valorCombo );
	}
	
	public void desmarcarOpcao( String id_combo, String valorCombo ) {
		WebElement element = createDriver().findElement( By.id( id_combo ) );
		Select combo = new Select( element );
		combo.deselectByVisibleText(  valorCombo  );
	}
	
	
	/******** Sincronismo (Esperas) ********/
	
	public void comecarEsperaImplicita( int tempoEmSegundos ) {
		createDriver().manage().timeouts().implicitlyWait( tempoEmSegundos, TimeUnit.SECONDS );
	}
	
	public void terminarEsperaImplicita() {
		createDriver().manage().timeouts().implicitlyWait( 0, TimeUnit.SECONDS );
	}
	
	public void esperarPelaPresençaDe(By by) {
		WebDriverWait wait = new WebDriverWait( createDriver(), 5 );
		wait.until( ExpectedConditions.presenceOfElementLocated( by ));
	}

	
	/******** Outros ********/
	
	public String retornarTexto( By by ) {
		return createDriver().findElement( by ).getText();
	}
	
	/******** Alertas ********/
	public void alertaAceitar() {
		Alert alerta = createDriver().switchTo().alert();
		alerta.accept();
	}
	

	
	/******** Tabelas ********/
	
	
}
