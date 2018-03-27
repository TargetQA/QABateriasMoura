package revendedorCadastro;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import java.lang.Thread.*;

public class VerificarRevendedor {
	
	@Test
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
	public void cadastrandoRevendedor() {
		
	}

}
