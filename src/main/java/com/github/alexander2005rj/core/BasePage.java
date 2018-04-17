package com.github.alexander2005rj.core;

import static com.github.alexander2005rj.core.DriverFactory.createDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
		createDriver().findElement( By.id( id_campo ) ).clear();
		createDriver().findElement( By.id( id_campo ) ).sendKeys( texto );;
	}
	
	public String obterValorCampo( String id_campo ) {
		return createDriver().findElement( By.id(id_campo) ).getAttribute("value");
	}
	
	public String obterTexto( String id_campo ) {
		return createDriver().findElement( By.id(id_campo) ).getText();
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
	
	public WebElement retornaElementoCombo( By by ) {
		return createDriver().findElement( by );
	}
	
	public void selecionarOpcao( String id_combo, String valorCombo ) {
		Select combo = new Select( retornaElementoCombo( By.id( id_combo ) ) );
		combo.selectByVisibleText( valorCombo );
	}
	
	public void selecionarOpcaoPorIndex( String id_combo, int index ) {
		Select combo = new Select( retornaElementoCombo( By.id( id_combo ) ) );
		combo.selectByIndex( index );
	}
	
	public int tamanhoDaCombo( String id_combo ) {
		Select combo = new Select( retornaElementoCombo( By.id( id_combo ) ) );
		List<WebElement> elementCount = combo.getOptions();
		return elementCount.size();
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
	
	public void esperarPelaPresencaDe(By by) {
		WebDriverWait wait = new WebDriverWait( createDriver(), 15 );
		wait.until( ExpectedConditions.presenceOfElementLocated( by ) );
	}
	
	public void esperarElementoClicavel( By by ) {
		WebDriverWait wait = new WebDriverWait( createDriver(), 15 );
		wait.until( ExpectedConditions.elementToBeClickable( by ) );
	}

	
	/******** Outros ********/
	
	public String retornarTexto( By by ) {
		String texto; 
		
		try {
			texto = createDriver().findElement( by ).getText();
		} catch ( NoSuchElementException e ) {
			texto = "Sem texto!";
		}
		return texto;
	}
	
	/******** Alertas ********/
	
	public void alertaAceitar() {
		Alert alerta = createDriver().switchTo().alert();
		alerta.accept();
	}
	
	public void alertaDesistir() {
		Alert alerta = createDriver().switchTo().alert();
		alerta.dismiss();
	}
	

	
	/******** Tabelas ********/
	
	public void carregarTabela( By by ) {
		esperarPelaPresencaDe( by );
		esperarElementoClicavel( by );
	}
	
	public void selecionarAcaoNaTabela( By by ) {
		createDriver().findElement( by ).click();		
	}
	
	public String obterTextoTabela( By by ) {
		return createDriver().findElement( by ).getText();
	}
	
		
	/******** Checkboxes ********/
	
	public void clicarCheck( By by ) {
		createDriver().findElement( by ).click();
	}
	
	public void clicarCheck( String id ) {
		clicarCheck(By.id( id ) );
	}
	
}
