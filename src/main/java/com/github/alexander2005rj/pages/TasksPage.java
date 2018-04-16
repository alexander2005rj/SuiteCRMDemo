package com.github.alexander2005rj.pages;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;


public class TasksPage extends BasePage {
	
	public void createTask() {
		esperarPelaPresencaDe( By.xpath( ".//a[@data-action-name='Create']" ) );
		// comecarEsperaImplicita( 5 );
		clicarNoLink( By.xpath( ".//a[@data-action-name='Create']" ) );
		//terminarEsperaImplicita();
	}
	
	public void viewTasks() {
		esperarPelaPresencaDe( By.xpath( ".//a[@data-action-name='List']" ) );
		// comecarEsperaImplicita( 5 );
		clicarNoLink( By.xpath( ".//a[@data-action-name='List']" ) );
		// terminarEsperaImplicita();
	}
	
	public void setSubject( String assunto ) {
		esperarPelaPresencaDe( By.id( "name" ));
		inserir( "name", assunto );
	}
	
	public String getSubject() {
		return obterValorCampo( "name" );
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
		esperarPelaPresencaDe( By.id( "SAVE" ));
		clicarNoBotao( "SAVE" );
	}
	
	public void cancel() {
		esperarPelaPresencaDe( By.id( "CANCEL" ) );
		clicarNoBotao( "CANCEL" );
		alertaAceitar();
	}
	
	public void closeAndCreateNew() {
		esperarPelaPresencaDe( By.xpath( "//input[@title='Close and Create New']" ) );
		clicarNoBotao( By.xpath( "//input[@title='Close and Create New']" ) );
	}
	
	
	public String obterTextoTaskCadastrada() {
		return retornarTexto( By.xpath( ".//h2[@class='module-title-text']" ) );
	}
	
	public String obterMensagemDeErro( String xpathMensagem ) {
		return retornarTexto( By.xpath( xpathMensagem ) );
	}
	
	public String buscarSubjectNaTabela( String assunto ) {
		comecarEsperaImplicita( 5 );
		return retornarTexto( By.xpath( ".//a[contains(text(),'" + assunto + "')]" ));
	}
	
	public void selecionarRegistroNaTabela() {
		
	}
	
}
