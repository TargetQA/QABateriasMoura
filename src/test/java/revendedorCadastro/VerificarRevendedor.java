package revendedorCadastro;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa.bateria.moura.core.DSL;
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
	
	/*@After
	public void finaliza(){
		driver.quit();
	}*/
	
	@Test
	@Ignore
	public void verificaRevendedorNaoCadastradoClickPesquisa() {		
		
	}
	
	
	@Test
	public void cadastrandoRevendedorCompleto()  {
		dsl.clicarBotaoCass("btn-moura");
		dsl.escrever(By.id("cnpj"), "73043466000148");
		dsl.clicarBotao("buscar-cnpj");
		dsl.escrever("nomeFantasia", "Calebe e Geraldo Auto Peças ME");
		dsl.escrever("razaoSocial", "Calebe e Geraldo Auto Peças ME");
		dsl.escrever("cep", "12085083");
		dsl.escrever("numero", "15");
		dsl.escrever("email", "orcamento@calebeegeraldoautopecas.com.br");
		dsl.escrever("telefone", "1235809979");
		
		dsl.isCheckMarcadoComEspaco("regulamento");
		
		
		
		
		
		
		
	}

}
