package qa.bateria.moura.basepage;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import qa.bateria.moura.core.DSL;

import org.junit.Assert;
import org.junit.Before;


	

public class PaginaUsuarioCadastro {
	

	private DSL dsl;
	private WebDriver driver;
	
	@Before
	public void inicializa() throws InterruptedException{
		//System.setProperty("webdriver.gecko.driver", "/home/bcarneiro/SeleniumDriver/geckodriver"); - utilizar no linux
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("http://server.target1.com.br:9020/#/portal/home");
		Thread.sleep(500);
		dsl = new DSL(driver);
	}
	
	@Test  // Verifica os campos obrigatorios de preenchiomento do cadastro
	       //tenta submeter o formul�rio fluxo de teste completo dos campos preenchidos
	
	public void verificaCamposDePreenchimentoVazio() throws InterruptedException{
		
		dsl.clicarBotaoClass("btn-moura");
		dsl.escreverId("cnpj", "40916109000198");
		dsl.clicarBotaoId("buscar-cnpj");
		Thread.sleep(10000);
		dsl.clicarBotaoId("enviar-cadastro-usuario"); //clica no bot�o enviar campos vazio
		
		//campo de preenchimento: nome
		//Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterValorTexto("nome-error"));
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "nome-error");
		dsl.escreverId("nome", "Giovanni Anthony Santos");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		
		//campo de preenchimento: cpf
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("cpf-error"));
		dsl.escreverId("cpf","64501237880");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		
		// campo de preenchimento: e-mail
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("email-error"));
		dsl.escreverId("email", "giovthonysantos@senioraereo.com.br");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
				
		// campo de preenchimento: endere�o 
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("endereco-error"));
		dsl.escreverId("endereco" ,"Rua Maria Ang�lica Assump��o Cagnani");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
				
		//campo de preenchimento: numero
		Assert.assertEquals("ESTE CAMPO � REQUERIDO." , dsl.obterTexto("numero-error"));
		dsl.escreverId("numero" , "657");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: bairro
		//Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("bairro-error"));
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "bairro-error");
		dsl.escreverId("bairro" , "Jardim Monte Almo");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		
		//campo de preenchimento: cidade
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("cidade-error"));
		dsl.escreverId("cidade" , "Po�os de Caldas");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: estado
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("estado-error"));
		new Select(driver.findElement(By.id("estado")))
		.selectByVisibleText("Minas Gerais");
		dsl.clicarBotaoId("enviar-cadastro-usuario");		
		
		//campo de preenchimento: CEP (autom�tico)
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("cep-error"));
		dsl.escreverId("cep" ,"37704022");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		Thread.sleep(3000);

		//campo de preenchimento: celular
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("celular-error"));
		dsl.escreverId("celular" , "35995552566");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
				
		//campo de preenchimento: sexo
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("sexo-error"));
		new Select(driver.findElement(By.id("sexo")))
		.selectByVisibleText("Masculino");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: data de nascimento
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("dataNascimento-error"));
		dsl.escreverId("dataNascimento" , "16031988");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: senha
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("senha-error"));
		dsl.escreverId("senha" , "123456");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: seleciona cargo
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("cargo-error"));
		dsl.clicarRadioId("cargoId1");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
				
		//campo de preenchimento: clica regulamento
		Assert.assertEquals("ESTE CAMPO � REQUERIDO.", dsl.obterTexto("regulamento-error"));
		dsl.clicarCheckId("regulamento");
		//ao clicar, deve cadastrar com sucesso
		//dsl.clicarBotaoId("enviar-cadastro-usuario");
			
		
		
	}

}







