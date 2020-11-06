package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Cont�m os campos e metodos utilzados na p�gina de garantia
 * */
public class PaginaGarantia {
	
	private WebDriver driver;
	
	private By botaoContinuar = By.xpath("//*[text()='Continuar']");
	
	public PaginaGarantia(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selecionarGarantia(String garantia) {
		driver.findElement(By.xpath("//*[text()='"+ garantia +"']")).click();
	}
	
	public void clicarBotaoContinuar() {
		driver.findElement(botaoContinuar).click();
	}
}
