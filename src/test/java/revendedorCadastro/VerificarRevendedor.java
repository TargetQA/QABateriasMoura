package revendedorCadastro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerificarRevendedor {
	
	@Test
	public void verificaRevendedorNaoCadastradoClickPesquisa() {
			
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://server.target1.com.br:9020/landing-page.html");
		driver.findElement(By.className("btn-moura")).click();
		driver.findElement(By.id("buscarRevendaCNPJ")).click();
		//assertEquals("", actual);
	}

}
