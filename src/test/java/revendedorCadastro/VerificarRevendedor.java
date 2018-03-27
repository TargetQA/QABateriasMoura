package revendedorCadastro;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junitparams.FileParameters;
import junitparams.mappers.CsvWithHeaderMapper;
import static org.junit.Assert.assertEquals;



public class VerificarRevendedor {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Test
	@Ignore
	public void verificaRevendedorNaoCadastradoClickPesquisa() throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "/home/bcarneiro/SeleniumDriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://server.target1.com.br:9020/landing-page.html");
		Thread.sleep(1000);
		driver.findElement(By.className("btn-moura")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btnBuscaRev")).click();
		assertEquals("Cadastro de Revendedor | Promoção Baterias Moura", driver.getTitle());
	}
	
	
	@Test
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
