package mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import Actions.MobileActions;
import Core.DSL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsClaroMobile {

	AndroidDriver<MobileElement> driverLocal;
	AndroidDriver<AndroidElement> driverBrowserStack;
	DSL dsl;
	MobileActions actions;
	String ValorA;
	String ValorB;
	String Local;

	@After
	public void tearDown() {
		switch (Local) {
		case "local":
			driverLocal.quit();
			break;
		case "BrowserStack":
			driverBrowserStack.quit();
			break;
		}
	}

	@Dado("que possuo um dispositivo {string} e desejo efetuar um teste {string}")
	public void que_possuo_um_dispositivo_e_desejo_efetuar_um_teste(String dispositivo, String local) {
		Local = local;
		switch (dispositivo) {
		case "Android":
			DesiredCapabilities caps = new DesiredCapabilities();
			if (local.contains("BrowserStack")) {
				caps.setCapability("browserstack.user", "eduardogallindo1");
				caps.setCapability("browserstack.key", "JbL3qj9pkz7cgBSz3RDF");
				caps.setCapability("app", "bs://e4a0a148274d023312cfc13283761d99d6d27478");
				caps.setCapability("device", "Google Nexus 6");
				caps.setCapability("os_version", "6.0");
				caps.setCapability("build", "Java Android");
				try {
					driverBrowserStack = new AndroidDriver<AndroidElement>(
							new URL("http://hub.browserstack.com/wd/hub"), caps);
					dsl = new DSL(driverBrowserStack);
					actions = new MobileActions(driverBrowserStack);
					driverBrowserStack.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					caps.setCapability("platformName", "Android");
					caps.setCapability("deviceName", "emulator-5554");
					caps.setCapability("automationName", "uiautomator2");
					caps.setCapability(MobileCapabilityType.APP,
							System.getProperty("user.dir") + "\\src\\main\\resources\\app-android-calculator.apk");
					driverLocal = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
					dsl = new DSL(driverLocal);
					actions = new MobileActions(driverLocal);
					driverLocal.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "IOS":
			break;
		}
	}

	@Dado("que desejo efetuar uma operação matemática com os valores {string} e {string}")
	public void que_desejo_efetuar_uma_operação_matemática_com_os_valores_e(String valorA, String valorB) {
		ValorA = valorA;
		ValorB = valorB;
	}

	@Quando("acessar o aplicativo da calculadora")
	public void acessar_o_aplicativo_da_calculadora() {
		actions.acessarCalculadoraAndroid();
	}

	@Então("devo somar os dois valores")
	public void devo_somar_os_dois_valores() {
		actions.somarValoresAndroid(ValorA, ValorB);
	}

	@Então("validar que o resultado da soma está correto")
	public void validar_que_o_resultado_da_soma_está_correto() {
		actions.validarResultadoSomaAndroid(ValorA, ValorB);
	}

	@Então("devo subtrair os dois valores")
	public void devo_subtrair_os_dois_valores() {
		actions.subtrairValoresAndroid(ValorA, ValorB);
	}

	@Então("validar que o resultado da subtração está correto")
	public void validar_que_o_resultado_da_subtração_está_correto() {
		actions.validarResultadoSubtracaoAndroid(ValorA, ValorB);
	}

	@Então("devo multiplicar os dois valores")
	public void devo_multiplicar_os_dois_valores() {
		actions.multiplicarValoresAndroid(ValorA, ValorB);
	}

	@Então("validar que o resultado da multiplicação está correto")
	public void validar_que_o_resultado_da_multiplicação_está_correto() {
		actions.validarResultadoMultiplicacaoAndroid(ValorA, ValorB);
	}

	@Então("devo dividir os dois valores")
	public void devo_dividir_os_dois_valores() {
		actions.dividirValoresAndroid(ValorA, ValorB);
	}

	@Então("validar que o resultado da divisão está correto")
	public void validar_que_o_resultado_da_divisão_está_correto() {
		actions.validarResultadodivisaoAndroid(ValorA, ValorB);
	}
}
