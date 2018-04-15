package com.github.alexander2005rj.pages;

import com.github.alexander2005rj.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarPaginaLogin() {
		acessarURL( "https://demo.suiteondemand.com/" );
	}
	
	public void setUsuario( String usuario ) {
		inserir( "user_name" , usuario );
	}
	
	public void setSenha( String senha ) {
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
