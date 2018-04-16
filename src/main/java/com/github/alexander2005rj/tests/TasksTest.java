package com.github.alexander2005rj.tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.alexander2005rj.core.BaseTest;
import com.github.alexander2005rj.pages.MenuPage;
import com.github.alexander2005rj.pages.TasksPage;


public class TasksTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private TasksPage taskPage = new TasksPage();
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testCadastrarTask() throws InterruptedException {
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
	public void testCamposObrigatorios() throws InterruptedException {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.save();
		
		String msgErro = taskPage.obterMensagemDeErro( ".//div[@type='name']/div" );
		
		Assert.assertEquals( "Missing required field: Subject" , msgErro );
		
		taskPage.cancel();
	}
	
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testDatasComFormatoIncorreto() throws InterruptedException {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.setSubject( "Testando datas com formato incorreto!" );
		taskPage.setStartDate( "1985/10/23", "07", "00" );
		taskPage.setDueDate( "23-10-1985", "11", "30" );
		
		taskPage.save();
		
		String msgErroStartDate = taskPage.obterMensagemDeErro( ".//div[.='Invalid Value: Start Date']" );
		String msgErroDueDate = taskPage.obterMensagemDeErro( ".//div[.='Invalid Value: Due Date']" );
		
		Assert.assertEquals( "Invalid Value: Start Date", msgErroStartDate );
		Assert.assertEquals( "Invalid Value: Due Date", msgErroDueDate );
		
		taskPage.cancel();
	}
	
	
	
	@Test
	@Ignore // ==> Retirar o @Ignore!
	public void testFecharECriarUmaNovaTask() throws InterruptedException {
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
		
		// Assert.assertEquals( assunto, taskPage.buscarSubjectNaTabela( assunto ) ); 
		
	}
	
	/*
	@Test
	public void testAlterarTask() throws InterruptedException {
		menuPage.acessarTasks();
				
		// Selecionar linha da tabela para alteração 
		// .//tr[x]//span[@class='suitepicon suitepicon-action-edit']
		
	}
	*/
	
	@Test
	public void testExcluirTask() throws InterruptedException {
		menuPage.acessarTasks();
		
		taskPage.selecionarRegistroDaTabela( ".//tr[" + 7 + "]//input[@class='listview-checkbox']" );
		
		taskPage.excluirRegistroDaTabela();
		
		// Selecionar linha da tabela para alteração / exclusão
		// .//tr[x]//input[@class='listview-checkbox']
		
		
	}
	
	
	/*
	@Test 
	public void testExcluirTasksPaginacao() throws InterruptedException {
		menuPage.acessarTasks();
		
		
	}
	
	@Test
	public void testDesistirExclusao() throws InterruptedException {
		menuPage.acessarTasks();
		
		
	}
	*/
}
