package qa.bateria.moura.basepage;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import qa.bateria.moura.core.DSL;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;




public class PaginaCadastroRevendedor {
	
	
	private DSL dsl;
	private WebDriver driver;
	
	@Before
	public void inicializa() throws InterruptedException{
		//System.setProperty("webdriver.gecko.driver", "/home/bcarneiro/SeleniumDriver/geckodriver"); - utilizar no linux
		//driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		driver.get("http://server.target1.com.br:9020/#/portal/home");
		Thread.sleep(500);
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	

	
	@Test
	public void pesquisaRevendedor() throws InterruptedException  {		
		
		dsl.clicarBotaoClass("btn-moura");
		dsl.clicarBotaoId("buscar-cnpj");
		String texto = driver.findElement(By.className("swal2-content")).getText();
		Assert.assertEquals("Digite um CNPJ Válido para continuar", texto);
		driver.findElement(By.className("swal2-confirm")).click();
		dsl.escreverId("cnpj", "40916109000198");
		dsl.clicarBotaoId("buscar-cnpj");
		Thread.sleep(1000);
		
		
	}
	
	
	@Test
	public void cadastrandoRevendedorCompleto() throws InterruptedException  {
		
		dsl.clicarBotaoClass("btn-moura");
		dsl.escreverId("cnpj", "16644982000194");
		dsl.clicarBotaoId("buscar-cnpj");
		Thread.sleep(500);
		dsl.escreverId("nomeFantasia", "Analu e Helena Adega1 ME");
		dsl.escreverId("razaoSocial", "Analu e Helena Adega1 ME");
		dsl.escreverId("cep", "04456140");
		dsl.escreverId("numero", "17");
		dsl.escreverId("email", "orcamento@calebeegeraldoautopeca.com.br");
		dsl.escreverId("telefone", "1235809975");
		dsl.clicarBotaoClass("selection");
		new Select(driver.findElement(By.className("select2-selection--single"))).selectByVisibleText("Alagoana Matriz");
		//dsl.selecionarComboPorVisibleText("distribuidorId", "Alagoana Matriz");
		dsl.isCheckMarcadoComEspaco("regulamento");
		
		
		
		
		
		
	}

}
