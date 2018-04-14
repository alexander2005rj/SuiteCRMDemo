package com.github.alexander2005rj.pages;

import com.github.alexander2005rj.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTasks() {
		clicarNoLink( "Activities" );
		clicarNoLink( "Tasks" );
	}
}
