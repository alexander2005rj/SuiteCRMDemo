package com.github.alexander2005rj.tests;

import org.junit.Assert;
import org.junit.Test;

import com.github.alexander2005rj.core.BaseTest;
import com.github.alexander2005rj.pages.MenuPage;
import com.github.alexander2005rj.pages.TasksPage;


public class TasksTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private TasksPage taskPage = new TasksPage();
	
	@Test
	public void testCadastrarTask() throws InterruptedException {
		menuPage.acessarTasks();
		taskPage.createTask();
						
		String assunto = taskPage.setSubject( "Teste de Cadastro de Task" );
		
		// taskPage.setStartDate( "04/14/2018" , "07", "45", "pm" );
		taskPage.setStartDate( "2018-04-14" , "17", "45" );
		
		// taskPage.setDueDate( "04/17/2018", "03", "00", "am" );
		taskPage.setDueDate( "2018-08-28", "03", "00" );
		
		taskPage.setPriority( "Low" );
		taskPage.setDescription( "Apenas criando uma task para teste..." );
		taskPage.setStatus( "In Progress" );
		taskPage.setRelatedTo( "Task", "White Cross Co" );
		taskPage.setContactName( "William Darcy" );
		taskPage.setAssignedTo( "Max Jensen" );
		
		taskPage.save();
		
		Assert.assertEquals( taskPage.obterTextoTaskCadastrada(), assunto.toUpperCase() );
	}
	
	/*
	@Test
	public void testCamposObrigatorios() {
	
		// xpath para mensagem Subject ==> .//div[@type='name']/div
		// mensagem ==> Missing required field: Subject 
		
	}
	
	
	@Test
	public void testCancelarCadastro() {
		
	}
	
	@Test
	public void testFecharECriarUmaNovaTask() {
		
	}
	
	@Test
	public void testAlterarTask() {
		menuPage.acessarTasks();
		taskPage.viewTask();
		
		
	}
	
	
	@Test
	public void testExcluirTask() {
		menuPage.acessarTasks();
		taskPage.viewTask();
				
	}
	
	@Test 
	public void testExcluirTasksPaginacao() {
		
	}
	
	@Test
	public void testDesistirExclusao() {
		
	}
	*/
}
