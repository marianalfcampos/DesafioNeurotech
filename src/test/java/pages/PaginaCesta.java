package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contém os campos e metodos utilzados na página da cesta
 * */
public class PaginaCesta {
	
	private WebDriver driver;
	
	private By linkProduto = By.cssSelector("a[class='link-default clearfix']");
	private By qtdProduto = By.name("productQuantity");

	public PaginaCesta(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Este método verifica se o produto selecionado econtra-se na cesta
	 * 
	 * Retorna falso se a cesta estiver vazia
	 * 
	 * Caso contrário, é recuparado link do produto que está na cesta,
	 * é verificado se o atributo 'title' é igual ao nome do produto adicionado,
	 * e se a quantidade é igual a '1'
	 * */
	public boolean verificaProdutoEstaNaSexta(String nome) {
		boolean retorno;
		
		if (driver.getPageSource().contains("sua cesta está vazia")) {
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
