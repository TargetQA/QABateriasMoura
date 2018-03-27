package revendedorCadastro;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junitparams.FileParameters;
import junitparams.mappers.CsvWithHeaderMapper;
import qa.bateria.moura.core.DSL;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;




public class VerificarRevendedor {
	
	
	private DSL dsl;
	private WebDriver driver;
	
	@Before
	public void inicializa(){
		//System.setProperty("webdriver.gecko.driver", "/home/bcarneiro/SeleniumDriver/geckodriver"); - utilizar no linux
		driver = new FirefoxDriver();
		driver.get("http://server.target1.com.br:9020/");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void verificaRevendedorNaoCadastradoClickPesquisa() {
		
		
	}
	
	
	@Test
	@Ignore
	@FileParameters(value = "src/test/resources/massa_de_dados.csv",
		mapper = CsvWithHeaderMapper.class)
	public void cadastrandoRevendedor() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://server.target1.com.br:9020/revendedor-cadastro.html");
		dsl.escrever("campocnpj", "03926599000187");
		Thread.sleep(500);
		dsl.clicarBotaoCass("btnBuscaRev");
		dsl.escrever("fantasia", "Enzo e Pietro Telecom ME");
		
		//driver.findElement(By.id("campocnpj")).sendKeys("03926599000187");		
		//driver.findElement(By.className("btnBuscaRev")).click();
		//driver.findElement(By.id("fantasia")).sendKeys("Enzo e Pietro Telecom ME");
		driver.findElement(By.id("razao_social")).sendKeys("Enzo e Pietro Telecom ME");
		driver.findElement(By.id("cadastro_cep")).sendKeys("18050600");
		driver.findElement(By.id("cadastro_numero")).sendKeys("1014");
		driver.findElement(By.id("email")).sendKeys("gardenal@gardenal.com.br");
		driver.findElement(By.id("telefone")).sendKeys("112458-5587");
		//dsl.selecionarCombo("9", valor);
		
		
		
		
		
		
	}

}
