package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaCesta;
import pages.PaginaGarantia;
import pages.PaginaInicial;
import pages.PaginaProduto;
import pages.PaginaProdutos;

public class AdicionarProdutoCestaSteps {
	
	private WebDriver driver = null;
	
	private PaginaInicial paginaInicial;
	private PaginaProdutos paginaProdutos;
	private PaginaProduto paginaProduto;
	private PaginaGarantia paginaGarantia;
	private PaginaCesta paginaCesta;
	
	/**
	 * Antes de iniciar os passo, inicializa o chromedriver
	 * */
	@Before
	public void configurarBrowser() throws InterruptedException {
	    String projectPath = System.getProperty("user.dir");
	    
	    System.setProperty("webdriver.chrome.driver", 
	    		projectPath + "/src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    
	    driver.manage().window().maximize();
	}
	
	/**
	 * Após executar os passos, fecha o browser
	 * */
	@After
	public void fecharBrowser() {
		driver.close();
		driver.quit();
	}
	
	/**
	 * Entra na página inicial
	 * */
	@Given("O usuario esta na pagina inicial")
	public void usuario_esta_na_pagina_inicial() {
	    driver.navigate().to("https://www.americanas.com.br/");
	    
	    this.paginaInicial = new PaginaInicial(driver);
	    this.paginaInicial.fecharPopPup();
	}

	/**
	 * Pesquisa o produto desejado
	 * */
	@When("O usuario pesquisa o produto {string}")
	public void o_usuario_pesquisa_o_produto(String produto) {
		this.paginaInicial.pesquisarProduto(produto);
	}

	/**
	 * Seleciona o prodito a ser adicionado na cesta
	 * */
	@And("Seleciona o produto {string}")
	public void seleciona_o_produto(String produto) {
		this.paginaProdutos = new PaginaProdutos(driver);
		this.paginaProdutos.selecionarProduto(produto);
	}

	/**
	 * Preenche o campo cep
	 * */
	@And("Preenche o cep {string}")
	public void preenche_o_cep(String cep) {
		this.paginaProduto = new PaginaProduto(driver);
		this.paginaProduto.preencherCep(cep);
	}

	/**
	 * Clica em comprar
	 * */
	@And("Clica em comprar")
	public void clica_em_comprar() {
		this.paginaProduto.clicarBotaoComprar();
	}

	/**
	 * Seleciona a garantia desejada
	 * */
	@And("Seleciona garantia {string}")
	public void seleciona_garantia(String garantia) {
		this.paginaGarantia = new PaginaGarantia(driver);
		this.paginaGarantia.selecionarGarantia(garantia);
	}

	/**
	 * Clica em continuar
	 * */
	@And("Clica em continuar")
	public void clica_em_continuar() throws InterruptedException {
		this.paginaGarantia.clicarBotaoContinuar();
		Thread.sleep(5000);
	}

	/**
	 * Verifica se o produto adicionado enconra-se na cesta
	 * */
	@Then("O produto deve estar na cesta")
	public void o_produto_deve_estar_na_cesta() {
		this.paginaCesta = new PaginaCesta(driver);
		
		String nome = this.paginaProdutos.getNomeProduto();
	    boolean produtoEstaNaSexta = this.paginaCesta.verificaProdutoEstaNaSexta(nome);
	    
	    assertTrue(produtoEstaNaSexta);
	}

}
