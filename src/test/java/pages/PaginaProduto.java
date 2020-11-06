package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Contém os campos e metodos utilzados na página do produto
 * */
public class PaginaProduto {
	
	private WebDriver driver;
	
	private By campoCep = By.name("cep");
	private By botaoOk = By.xpath("//*[text()='ok']");
	private By botaoComprar = By.linkText("comprar");
		
	public PaginaProduto(WebDriver driver) {
		this.driver = driver;
	}
	
	public void digitarCep(String cep) {
		driver.findElement(campoCep).sendKeys(cep);
	}
	
	public void clicarBotaoOk() {
		driver.findElement(botaoOk).submit();
	}
	
	public void preencherCep(String cep) {
		this.digitarCep(cep);
		this.clicarBotaoOk();
	}
	
	public void clicarBotaoComprar() {
		driver.findElement(botaoComprar).click();
	}

}
