package com.github.alexander2005rj.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.github.alexander2005rj.core.BasePage;


public class TasksPage extends BasePage {
	
	public void createTask() {
		esperarPelaPresencaDe( By.xpath( ".//a[@data-action-name='Create']" ) );
		clicarNoLink( By.xpath( ".//a[@data-action-name='Create']" ) );
	}
	
	public void viewTasks() {
		esperarPelaPresencaDe( By.xpath( ".//a[@data-action-name='List']" ) );
		esperarElementoClicavel( By.xpath( ".//a[@data-action-name='List']" ) );
		clicarNoLink( By.xpath( ".//a[@data-action-name='List']" ) );
		carregarTabela( By.xpath( ".//table[@class='list view table-responsive']" ) );
	}
	
	public void carregandoTabela() {
		carregarTabela( By.xpath( ".//table[@class='list view table-responsive']" ) );
		
		esperarPelaPresencaDe( By.id( "actionLinkTop" ));
		esperarElementoClicavel( By.id( "actionLinkTop" ));
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
	
	public String obterMensagemDeErro() {
		return retornarTexto( By.xpath( ".//div[@type='name']/div" ) );
	}
	
	public String obterErroDataInicio() {
		return retornarTexto( By.xpath( ".//div[.='Invalid Value: Start Date']" ) );
	}
	
	public String obterErroDataVencimento() {
		return retornarTexto( By.xpath( ".//div[.='Invalid Value: Due Date']" ) );
	}
	
	
	public String buscarInfoNaTabela( String info ) {
		carregarTabela( By.xpath( ".//table[@class='list view table-responsive']" ) );
		
		// esperarPelaPresencaDe( By.xpath( ".//a[contains(text(),'" + info + "')]" ) );
		
		return retornarTexto( By.xpath( ".//a[contains(text(),'" + info + "')]" ) );
	}
		
	public void editarRegistroDaTabela( String xpathEditar ) {
		carregarTabela( By.xpath( ".//table[@class='list view table-responsive']" ) );
		
		esperarElementoClicavel( By.xpath( xpathEditar ) );
		selecionarAcaoNaTabela( By.xpath( xpathEditar ) );
	}
	
	public List<String> selecionarRegistroDaTabela( int numAleatorio ) {
		carregarTabela( By.xpath( ".//table[@class='list view table-responsive']" ) );
		
		esperarPelaPresencaDe( By.xpath( ".//tr[" + numAleatorio + "]//input[@class='listview-checkbox']" ) );
		esperarElementoClicavel( By.xpath( ".//tr[" + numAleatorio + "]//input[@class='listview-checkbox']" ) );
		
		String assunto = obterTextoTabela( By.xpath( ".//tr[" + numAleatorio + "]//td[@type='name']//a" ) );
		String contato = obterTextoTabela( By.xpath( ".//tr[" + numAleatorio + "]//td[@type='relate']//a" ) );
		
		List<String> listaContato = new ArrayList<String>();
		listaContato.add(assunto);
		listaContato.add(contato);
		
		clicarCheck( By.xpath( ".//tr[" + numAleatorio + "]//input[@class='listview-checkbox']" ) );
		
		return listaContato;
	}
	
	
	public void selecionarBulkAction() {
		carregarTabela( By.xpath( ".//table[@class='list view table-responsive']" ) );
		
		esperarPelaPresencaDe( By.id( "actionLinkTop" ));
		esperarElementoClicavel( By.id( "actionLinkTop" ));
	}
	
	public void selecionarAcaoExclusao() {
		selecionarBulkAction();
				
		esperarPelaPresencaDe( By.id( "delete_listview_top" ));
		esperarElementoClicavel( By.id( "delete_listview_top" ));
		clicarNoLinkPorId( "delete_listview_top" );
		
		esperarPelaPresencaDe( By.xpath( ".//a[.='Delete']" ) );
		esperarElementoClicavel( By.xpath( ".//a[.='Delete']" ) );
		clicarNoLink( By.xpath( ".//a[.='Delete']" ) );
	}
	
	public void excluirRegistroDaTabela() {
		selecionarAcaoExclusao();
		alertaAceitar();
	}
	
	
	public void desistirExclusao() {
		selecionarAcaoExclusao();
		alertaDesistir();
	}
}
