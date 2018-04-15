package com.github.alexander2005rj.pages;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTasks() throws InterruptedException {
		esperarPelaPresençaDe( By.id( "toolbar" ) );
		clicarNoLinkPorId( "grouptab_3" );
		clicarNoLinkPorId( "moduleTab_6_Tasks" );
	}
	
	public void acessarToolBarContaUsuario() {
		esperarPelaPresençaDe( By.id( "globalLinks" ) );
		clicarNoBotao( "with-label" );
	}
	
	/*
	public void logout() {
		acessarToolBarContaUsuario();
		clicarNoLinkPorId( "logout_link" );
		alertaAceitar();
	}
	*/
}
