package com.github.alexander2005rj.pages;

import com.github.alexander2005rj.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTasks() throws InterruptedException {
		comecarEsperaImplicita( 5 );
		clicarNoLinkPorId( "grouptab_3" );
		clicarNoLinkPorId( "moduleTab_6_Tasks" );
		terminarEsperaImplicita();
	}
}
