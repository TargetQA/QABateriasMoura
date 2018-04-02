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


	

public class PaginaCadastroUsuario {
	

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
	
	 // Verifica os campos obrigatorios de preenchiomento do cadastro
	 // Tenta submeter o formul�rio fluxo de teste completo dos campos preenchidos
	@Test 
	public void verificaCamposDePreenchimentoVazio() throws InterruptedException{
		
		dsl.clicarBotaoClass("btn-moura");
		dsl.escreverId("cnpj", "40916109000198");
		dsl.clicarBotaoId("buscar-cnpj");
		Thread.sleep(10000);
		dsl.clicarBotaoId("enviar-cadastro-usuario"); //clica no bot�o enviar campos vazio
		
		//campo de preenchimento: nome
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "nome-error");
		dsl.escreverId("nome", "Giovanni Anthony Santos");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		
		//campo de preenchimento: cpf
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "cpf-error");
		dsl.escreverId("cpf","64501237880");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		
		// campo de preenchimento: e-mail
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "email-error");
		dsl.escreverId("email", "giovthonysantos@senioraereo.com.br");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
				
		// campo de preenchimento: endere�o 
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "endereco-error");
		dsl.escreverId("endereco" ,"Rua Maria Ang�lica Assump��o Cagnani");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
				
		//campo de preenchimento: numero
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "numero-error");
		dsl.escreverId("numero" , "657");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: bairro
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "bairro-error");
		dsl.escreverId("bairro" , "Jardim Monte Almo");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		
		//campo de preenchimento: cidade
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "cidade-error");
		dsl.escreverId("cidade" , "Po�os de Caldas");
		dsl.clicarBotaoId("enviar-cadastro-usuario");  
		
		//campo de preenchimento: estado
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "estado-error");
		dsl.selecionarComboPorVisibleText("estado", "Minas Gerais");
		dsl.clicarBotaoId("enviar-cadastro-usuario");		
		
		//campo de preenchimento: CEP (autom�tico)
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "cep-error");
		dsl.escreverId("cep" ,"37704022");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
		Thread.sleep(1000);

		//campo de preenchimento: celular
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "celular-error");
		dsl.escreverId("celular" , "35995552566");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
				
		//campo de preenchimento: sexo
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO." , "sexo-error");
		dsl.selecionarComboPorVisibleText("sexo", "Masculino");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: data de nascimento
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "dataNascimento-error");
		dsl.escreverId("dataNascimento" , "16031988");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: senha
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "senha-error");
		dsl.escreverId("senha" , "123456");
		dsl.clicarBotaoId("enviar-cadastro-usuario"); 
		
		//campo de preenchimento: seleciona cargo
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "cargo-error");
		dsl.clicarRadioId("cargoId1");
		dsl.clicarBotaoId("enviar-cadastro-usuario");
				
		//campo de preenchimento: clica regulamento
		dsl.checarCampoObrigatorio("ESTE CAMPO � REQUERIDO.", "regulamento-error");
		dsl.clicarCheckId("regulamento");		
		
		//ao clicar, deve cadastrar com sucesso [manter ainda como coment�rio]
		//dsl.clicarBotaoId("enviar-cadastro-usuario");
			
		
		
	}

}







