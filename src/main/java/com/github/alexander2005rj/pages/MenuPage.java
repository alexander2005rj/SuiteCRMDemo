package com.github.alexander2005rj.pages;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTasks() throws InterruptedException {
		esperarPelaPresencaDe( By.id( "toolbar" ) );
		
		esperarPelaPresencaDe( By.id( "grouptab_3" ) );
		clicarNoLinkPorId( "grouptab_3" );
		
		esperarPelaPresencaDe( By.id( "moduleTab_6_Tasks" ) );
		clicarNoLinkPorId( "moduleTab_6_Tasks" );
	}
	
}
