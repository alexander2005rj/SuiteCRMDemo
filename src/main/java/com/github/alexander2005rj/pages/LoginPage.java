package com.github.alexander2005rj.pages;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarPaginaLogin() {
		acessarURL( "https://demo.suiteondemand.com/" );
	}
	
	public void setUsuario( String usuario ) {
		esperarPelaPresencaDe( By.id( "user_name" ) );
		inserir( "user_name" , usuario );
	}
	
	public void setSenha( String senha ) {
		esperarPelaPresencaDe( By.id( "username_password" ) );
		inserir( "username_password", senha );
	}
	
	public void entrar() {
		clicarNoBotao( "bigbutton" );
	}
	
	public void logar( String usuario, String senha ) {
		acessarPaginaLogin();
		setUsuario( usuario );
		setSenha( senha );
		entrar();
	}
	
}
