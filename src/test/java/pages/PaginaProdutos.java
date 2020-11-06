package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contém os campos e metodos utilzados na página de produtos
 * */
public class PaginaProdutos {
	
	private WebDriver driver;
	
	private String nomeProduto;
		
	public PaginaProdutos(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Essse método pega os elementos que contém o nome do produto e seleciona o primeiro
	 * 
	 * O nome do produto delecionado é armazenado na variável nomeProduto para que,
	 * no ultimo passo, seja verificado se ele se encontra na cesta
	 * */
	public void selecionarProduto(String produto) {
		List<WebElement> elementsList = driver.findElements(By.xpath("//*[contains(text(),'"+ produto +"')]"));
		WebElement produtoSelecionar = elementsList.get(0);
		
		this.nomeProduto = produtoSelecionar.getText();
		
		produtoSelecionar.click();
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

}
