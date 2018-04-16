package com.github.alexander2005rj.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.alexander2005rj.core.BaseTest;
import com.github.alexander2005rj.pages.MenuPage;
import com.github.alexander2005rj.pages.TasksPage;
import com.github.alexander2005rj.utils.Utility;


public class TasksTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private TasksPage taskPage = new TasksPage();
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testCadastrarTask() {
		menuPage.acessarTasks();
		taskPage.createTask();
						
		taskPage.setSubject( "Teste de Cadastro de Task" );
		
		taskPage.setStartDate( "04/14/2018" , "07", "45", "pm" );
		//taskPage.setStartDate( "2018-04-14" , "17", "45" );
		
		taskPage.setDueDate( "04/17/2018", "03", "00", "am" );
		// taskPage.setDueDate( "2018-08-28", "03", "00" );
		
		taskPage.setPriority( "Low" );
		taskPage.setDescription( "Apenas criando uma task para teste..." );
		taskPage.setStatus( "In Progress" );
		taskPage.setRelatedTo( "Task", "White Cross Co" );
		taskPage.setContactName( "William Darcy" );
		taskPage.setAssignedTo( "Max Jensen" );
		
		taskPage.save();
				
		Assert.assertEquals( taskPage.obterTextoTaskCadastrada(), taskPage.getSubject().toUpperCase() );
	}
	
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testCamposObrigatorios() {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.save();
		
		Assert.assertEquals( "Missing required field: Subject" , taskPage.obterMensagemDeErro() );
		
		taskPage.cancel();
	}
	
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testDatasComFormatoIncorreto() {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.setSubject( "Testando datas com formato incorreto!" );
		taskPage.setStartDate( "1985/10/23", "07", "00" );
		taskPage.setDueDate( "23-10-1985", "11", "30" );
		
		taskPage.save();
		
		Assert.assertEquals( "Invalid Value: Start Date", taskPage.obterErroDataInicio() );
		Assert.assertEquals( "Invalid Value: Due Date", taskPage.obterErroDataVencimento() );
		
		taskPage.cancel();
	}
	
	
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testFecharECriarUmaNovaTask() {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.setSubject( "Criando task, fechando e criando uma nova" );
		String assunto = taskPage.getSubject();
		
		taskPage.setDescription( "Sem comentários por agora..." );
		taskPage.setRelatedTo( "Bug", "First National S/B" );
		taskPage.setContactName( "Mary Belle" );
		taskPage.setAssignedTo( "Chris Olliver" );
		
		taskPage.closeAndCreateNew();
		
		// taskPage.viewTasks();
		
		Assert.assertEquals( assunto, taskPage.buscarInfoNaTabela( assunto ) ); 
		
	}
	
	/*
	@Test
	public void testAlterarTask() {
		menuPage.acessarTasks();
				
		// Selecionar linha da tabela para alteração 
		// .//tr[x]//span[@class='suitepicon suitepicon-action-edit']
		
	}
	*/
	
	@Test
	public void testExcluirTask() {
		menuPage.acessarTasks();
		
		List<String> listaContato = taskPage.selecionarRegistroDaTabela( Utility.sortearNumeroMenorQue( 21 )  );
		String assunto = listaContato.get( 0 );
		String contato = listaContato.get( 1 );
			
		taskPage.excluirRegistroDaTabela();
		Assert.assertNotEquals( contato + " - " + assunto, taskPage.buscarInfoNaTabela( contato )  + " - " + taskPage.buscarInfoNaTabela( assunto ) );
	}
	
	
		
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testDesistirExclusao() {
		menuPage.acessarTasks();
					
		List<String> listaContato = taskPage.selecionarRegistroDaTabela( Utility.sortearNumeroMenorQue( 21 )  );
		String assunto = listaContato.get( 0 );
		String contato = listaContato.get( 1 );
		
		taskPage.desistirExclusao();
		Assert.assertEquals( contato + " - " + assunto, taskPage.buscarInfoNaTabela( contato )  + " - " + taskPage.buscarInfoNaTabela( assunto ) );
	}
	
}
