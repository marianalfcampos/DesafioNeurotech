package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Cont�m os campos e metodos utilzados na p�gina da cesta
 * */
public class PaginaCesta {
	
	private WebDriver driver;
	
	private By linkProduto = By.cssSelector("a[class='link-default clearfix']");
	private By qtdProduto = By.name("productQuantity");

	public PaginaCesta(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Este m�todo verifica se o produto selecionado econtra-se na cesta
	 * 
	 * Retorna falso se a cesta estiver vazia
	 * 
	 * Caso contr�rio, � recuparado link do produto que est� na cesta,
	 * � verificado se o atributo 'title' � igual ao nome do produto adicionado,
	 * e se a quantidade � igual a '1'
	 * */
	public boolean verificaProdutoEstaNaSexta(String nome) {
		boolean retorno;
		
		if (driver.getPageSource().contains("sua cesta est� vazia")) {
			retorno = false;
		} else {
			WebElement link = driver.findElement(linkProduto);
			String title = link.getAttribute("title");
			
			WebElement qtd = driver.findElement(qtdProduto);
			String valor = qtd.getAttribute("value");
			
			if (title.equalsIgnoreCase(nome) && valor.contentEquals("1")) {
				retorno = true;
			} else {
				retorno = false;
			}
		}
		
		return retorno;
	}
}
