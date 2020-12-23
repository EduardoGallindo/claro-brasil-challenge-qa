package Actions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import Core.DSL;
import PageObjects.MobileObjects;

public class MobileActions {
	WebDriver driver;
	DSL dsl;

	public MobileActions(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}

	public void acessarCalculadoraAndroid() {
		assertEquals("Simple Calculator Android", dsl.obterTexto(MobileObjects.TituloCalculadoraAndroid));
	}

	public void somarValoresAndroid(String valorA, String valorB) {
		dsl.escrever(MobileObjects.CampoPrimeiroValorAndroid, valorA);
		dsl.escrever(MobileObjects.CampoSegundoValorAndroid, valorB);
		driver.navigate().back();
		dsl.clicar(MobileObjects.botaoSomaAndroid);
	}

	public void validarResultadoSomaAndroid(String valorA, String valorB) {
		String resultado = dsl.obterTexto(MobileObjects.CampoResultadoAndroid);
		int Resultado = Integer.parseInt(valorA) + Integer.parseInt(valorB);
		assertEquals(String.valueOf(Resultado), resultado);
	}
	
	public void subtrairValoresAndroid(String valorA, String valorB) {
		dsl.escrever(MobileObjects.CampoPrimeiroValorAndroid, valorA);
		dsl.escrever(MobileObjects.CampoSegundoValorAndroid, valorB);
		driver.navigate().back();
		dsl.clicar(MobileObjects.botaoSubtraiAndroid);
	}

	public void validarResultadoSubtracaoAndroid(String valorA, String valorB) {
		String resultado = dsl.obterTexto(MobileObjects.CampoResultadoAndroid);
		int Resultado = Integer.parseInt(valorA) - Integer.parseInt(valorB);
		assertEquals(String.valueOf(Resultado), resultado);
	}
	
	public void multiplicarValoresAndroid(String valorA, String valorB) {
		dsl.escrever(MobileObjects.CampoPrimeiroValorAndroid, valorA);
		dsl.escrever(MobileObjects.CampoSegundoValorAndroid, valorB);
		driver.navigate().back();
		dsl.clicar(MobileObjects.botaoMultiplicaAndroid);
	}

	public void validarResultadoMultiplicacaoAndroid(String valorA, String valorB) {
		String resultado = dsl.obterTexto(MobileObjects.CampoResultadoAndroid);
		int Resultado = Integer.parseInt(valorA) * Integer.parseInt(valorB);
		assertEquals(String.valueOf(Resultado), resultado);
	}
	
	public void dividirValoresAndroid(String valorA, String valorB) {
		dsl.escrever(MobileObjects.CampoPrimeiroValorAndroid, valorA);
		dsl.escrever(MobileObjects.CampoSegundoValorAndroid, valorB);
		driver.navigate().back();
		dsl.clicar(MobileObjects.botaoDivideAndroid);
	}

	public void validarResultadodivisaoAndroid(String valorA, String valorB) {
		String resultado = dsl.obterTexto(MobileObjects.CampoResultadoAndroid);
		int Resultado = Integer.parseInt(valorA) / Integer.parseInt(valorB);
		assertEquals(String.valueOf(Resultado), resultado);
	}
}
