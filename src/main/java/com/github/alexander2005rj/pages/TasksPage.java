package com.github.alexander2005rj.pages;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;


public class TasksPage extends BasePage {
	
	public void setSubject() {
		
	}
		
	public void setStartDate() {
			
	}
	
	public void setDueDate() {
		
	}
	
	public void setPriority() {
		
	}
	
	public void setDescription() {
		
	}
	
	public void setStatus() {
		
	}
	
	public void setRelatedTo() {
		
	}
	
	public void setContactName() {
		
	}
	
	public void setAssignedTo() {
		
	}
	
	public void save() {
		clicarNoBotao( "SAVE" );
	}
	
	public void cancel() {
		clicarNoBotao( "CANCEL" );
	}
	
	public void closeAndCreateNew() {
		clicarNoBotao( By.xpath( "//input[@title='Close and Create New']" ) );
	}
	
	
}
