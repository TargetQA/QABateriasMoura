package revendedorCadastro;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

import static org.junit.Assert.assertEquals;

import java.lang.Thread.*;

@RunWith(JUnitParamsRunner.class)
public class VerificarRevendedor {
	
	@Test
	@Ignore
	public void verificaRevendedorNaoCadastradoClickPesquisa() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/home/bcarneiro/SeleniumDriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://server.target1.com.br:9020/landing-page.html");
		Thread.sleep(1000);
		driver.findElement(By.className("btn-moura")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("btnBuscaRev")).click();
		assertEquals("Cadastro de Revendedor | Promoção Baterias Moura", driver.getTitle());
	}
	
	@Test
	@FileParameters(value = "src/test/resource/massa_de_dados.csv", 
				mapper = CsvWithHeaderMapper.class)
	public void cadastrandoRevendedor(String fantasia, String razao_social, int cadastro_cep, int cadastro_numero, int cadastro_complemento, String email, int telefone, String distribuidor) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://server.target1.com.br:9020/revendedor-cadastro.html");
		driver.findElement(By.id(fantasia)).sendKeys(fantasia);
		
		/*driver.navigate().to("http://server.target1.com.br:9020/revendedor-cadastro.html");
		Thread.sleep(1000);
		driver.findElement(By.id("campocnpj")).sendKeys("03926599000187");
		driver.findElement(By.className("btnBuscaRev")).click();
		driver.findElement(By.id("fantasia")).sendKeys("Enzo e Pietro Telecom ME");
		driver.findElement(By.id("razao_social")).sendKeys("Enzo e Pietro Telecom ME");
		driver.findElement(By.id("razao_social")).sendKeys("Enzo e Pietro Telecom ME");
		*/
		
	}

}
