package com.github.alexander2005rj.pages;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;


public class TasksPage extends BasePage {
	
	public void createTask() {
		esperarPelaPresençaDe( By.xpath( ".//a[@data-action-name='Create']" ) );
		clicarNoLink( By.xpath( ".//a[@data-action-name='Create']" ) );
	}
	
	public void viewTasks() {
		esperarPelaPresençaDe( By.xpath( ".//a[@data-action-name='List']" ) );
		clicarNoLink( By.xpath( ".//a[@data-action-name='List']" ) );
	}
	
	public String setSubject( String assunto ) {
		esperarPelaPresençaDe( By.id( "name" ));
		inserir( "name", assunto );
		return assunto;
	}
		
	public void setStartDate( String dataInicio, String hora, String minutos ) {
		inserir( "date_start_date", dataInicio );
		selecionarOpcao( "date_start_hours", hora );
		selecionarOpcao( "date_start_minutes", minutos );
	}
	
	// Quando tem turno AM / PM
	public void setStartDate( String dataInicio, String hora, String minutos, String turno ) {
		inserir( "date_start_date", dataInicio );
		selecionarOpcao( "date_start_hours", hora );
		selecionarOpcao( "date_start_minutes", minutos );
		selecionarOpcao( "date_start_meridiem", turno );
	}
	
	public void setDueDate( String dataVencimento, String hora, String minutos ) {
		inserir( "date_due_date", dataVencimento );
		selecionarOpcao( "date_due_hours", hora );
		selecionarOpcao( "date_due_minutes", minutos );	
	}
	
	// Quando tem turno AM / PM
	public void setDueDate( String dataVencimento, String hora, String minutos, String turno ) {
		inserir( "date_due_date", dataVencimento );
		selecionarOpcao( "date_due_hours", hora );
		selecionarOpcao( "date_due_minutes", minutos );	
		selecionarOpcao( "date_due_meridiem" , turno );
	}
	
	public void setPriority( String prioridade ) {
		selecionarOpcao( "priority", prioridade );	
	}
	
	public void setDescription( String descricao ) {
		inserir( "description" , descricao );
	}
	
	public void setStatus( String status ) {
		selecionarOpcao( "status", status );
	}
	
	public void setRelatedTo( String tipo, String nome ) {
		selecionarOpcao( "parent_type", tipo );
		
		// Melhorar a busca por nome
		inserir( "parent_name", nome );
	}
	
	public void setContactName( String nomeDoContato ) {
		// Melhorar a busca por nome
		inserir( "contact_name", nomeDoContato );
	}
	
	public void setAssignedTo( String pessoaResponsavel ) {
		// Melhorar a busca por nome
		inserir( "assigned_user_name", pessoaResponsavel );
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
	
	
	public String obterTextoTaskCadastrada() {
		return retornarTexto( By.xpath( ".//h2[@class='module-title-text']" ) );
	}
	
	
}
