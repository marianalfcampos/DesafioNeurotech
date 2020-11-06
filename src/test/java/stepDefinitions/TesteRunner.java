package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Classe que roda os testes
 * */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
glue={"stepDefinitions"}, 
monochrome = true)
public class TesteRunner {

}
