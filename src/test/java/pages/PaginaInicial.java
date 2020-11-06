package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contém os campos e metodos utilzados na página inicial
 * */
public class PaginaInicial {
	
	private WebDriver driver;
	
	private By camposPesquisar = By.id("h_search-input");
	private By botaoPesquisar = By.id("h_search-btn");
	
	public PaginaInicial(WebDriver driver) {
		this.driver = driver;
	}
	
	public void digitarNomeProduto(String productName) {
		driver.findElement(camposPesquisar).sendKeys(productName);
	}
	
	public void clickarBotaoPesquisar() {
		driver.findElement(botaoPesquisar).sendKeys(Keys.ENTER);
	}
	
	public void pesquisarProduto(String productName) {
		digitarNomeProduto(productName);
		clickarBotaoPesquisar();
	}
	
	public void fecharPopPup() {
		if(driver.getPageSource().contains("continuar e fechar")){
		    WebElement popPup = driver.findElement(By.id("lgpd-accept"));
		    popPup.click();
	    }
	}
}
