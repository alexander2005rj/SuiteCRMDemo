package com.github.alexander2005rj.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.alexander2005rj.core.BaseTest;
import com.github.alexander2005rj.pages.MenuPage;
import com.github.alexander2005rj.pages.TasksPage;
import com.github.alexander2005rj.utils.Utility;
import com.github.javafaker.Faker;


public class TasksTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private TasksPage taskPage = new TasksPage();
	private Faker faker = new Faker();
	
	@Test
	public void testCadastrarTask() {
		menuPage.acessarTasks();
		taskPage.createTask();
						
		taskPage.setSubject( faker.lorem().sentence() );
		String assunto = taskPage.getSubject();
		
		taskPage.setStartDate( "04/14/2018" , "07", "45", "pm" );
		//taskPage.setStartDate( "2018-04-14" , "17", "45" );
		
		taskPage.setDueDate( "04/17/2018", "03", "00", "am" );
		// taskPage.setDueDate( "2018-08-28", "03", "00" );
		
		taskPage.setRelatedTo( "Task", "White Cross Co" );
		taskPage.setContactName( "William Darcy" );
		taskPage.setAssignedTo( "Max Jensen" );
		
		taskPage.setPriority();
		taskPage.setDescription( faker.lorem().paragraph() );
		taskPage.setStatus();
		
		taskPage.save();
		
		Assert.assertEquals( taskPage.obterTextoTaskCadastrada(), assunto.toUpperCase() );
	}
	
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.save();
		
		Assert.assertEquals( "Missing required field: Subject" , taskPage.obterMensagemDeErro() );
		
		taskPage.cancel();
	}
	
	
	@Test
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
	public void testFecharECriarUmaNovaTask() {
		menuPage.acessarTasks();
		taskPage.createTask();
		
		taskPage.setSubject( faker.lorem().sentence() );
		String assunto = taskPage.getSubject();
		
		taskPage.setDescription( faker.lorem().paragraph() );
		taskPage.setRelatedTo( "Bug", "First National S/B" );
		taskPage.setContactName( "Mary Belle" );
		taskPage.setAssignedTo( "Chris Olliver" );
		
		taskPage.closeAndCreateNew();
		
		taskPage.viewTasks();
		
		Assert.assertEquals( assunto, taskPage.buscarInfoNaTabela( assunto ) ); 
	}
	
	
	@Test
	public void testAlterarTask() {
		menuPage.acessarTasks();
		
		taskPage.editarTask( Utility.sortearNumeroMenorQue( 21 ) );
		String antigoTitulo = taskPage.getSubject();
		String antigoStatus = taskPage.getStatus();
		String antigaPrioridade = taskPage.getPriority();
		
		 
		taskPage.setSubject( faker.chuckNorris().fact()  );
		String novoTitulo = taskPage.getSubject();
		
		taskPage.setStatus();
		String novoStatus = taskPage.getStatus();
		
		taskPage.setPriority();
		String novaPrioridade = taskPage.getPriority();
		
		taskPage.save();
		
		Assert.assertNotEquals( antigoTitulo, novoTitulo );
		Assert.assertNotEquals( antigoStatus, novoStatus );
		Assert.assertNotEquals( antigaPrioridade, novaPrioridade );
	}
	
	
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
	public void testDesistirExclusao() {
		menuPage.acessarTasks();
					
		List<String> listaContato = taskPage.selecionarRegistroDaTabela( Utility.sortearNumeroMenorQue( 21 )  );
		String assunto = listaContato.get( 0 );
		String contato = listaContato.get( 1 );
		
		taskPage.desistirExclusao();
		Assert.assertEquals( contato + " - " + assunto, taskPage.buscarInfoNaTabela( contato )  + " - " + taskPage.buscarInfoNaTabela( assunto ) );
	}
	
}
