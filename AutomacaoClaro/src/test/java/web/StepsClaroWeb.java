package web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Actions.ChromeActions;
import Core.DSL;
import PageObjects.ChromeObjects;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Mas;
import io.cucumber.java.pt.Quando;

public class StepsClaroWeb {

	WebDriver driver;
	DSL dsl;
	ChromeActions actions;

	public static final String USERNAME = "eduardogallindo1";
	public static final String AUTOMATE_KEY = "JbL3qj9pkz7cgBSz3RDF";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@After
	public void tearDown() {
		driver.quit();
	}

	@Dado("que desejo efetuar o teste no navegador {string} na máquina {string}")
	public void que_desejo_efetuar_o_teste_no_navegador_na_máquina(String navegador, String local) {
		switch (navegador) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-notifications");
			if (local.contains("BrowserStack")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "87.0");
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				try {
					driver = new RemoteWebDriver(new URL(URL), caps);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else {
				driver = new ChromeDriver(options);
			}
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dsl = new DSL(driver);
		actions = new ChromeActions(driver);
	}

	@Dado("que desejo me cadastrar no site automationpractice")
	public void que_desejo_me_cadastrar_no_site_automationpractice() {
		driver.get("http://automationpractice.com/");
	}

	@Dado("que desejo acessar minha conta no site automationpractice")
	public void que_desejo_acessar_minha_conta_no_site_automationpractice() {
		dsl.acessarSite("http://automationpractice.com/");
	}

	@Mas("o meu email já foi cadastrado anteriormente")
	public void o_meu_email_já_foi_cadastrado_anteriormente() {
	}

	@Quando("acessar o site")
	public void acessar_o_site() {
		dsl.validaTitulo("My Store");
	}

	@Então("devo preencher o {string} da minha nova conta e clicar no botão Create an account")
	public void devo_preencher_meu_e_mail(String email) {
		actions.preencheEmailCriacao(email);
	}

	@Quando("for direcionado para a aba de dados da conta")
	public void for_direcionado_para_a_aba_de_dados_da_conta() {
		dsl.validaTexto("CREATE AN ACCOUNT", ChromeObjects.textoCriarConta);
	}

	@Então("devo preencher meu {string}, {string} e {string}")
	public void devo_preencher_meu_e(String nome, String sobrenome, String datanasc) {
		actions.preencheDadosPessoais(nome, sobrenome, datanasc);
	}

	@Então("escolher uma {string}")
	public void escolher_uma(String senha) {
		actions.preencheSenha(senha);
	}

	@Então("preencher os dados de endereço")
	public void preencher_os_dados_de_endereço() {
		actions.preencheEndereço();
	}

	@Então("preencher o {string}")
	public void preencher_o(String celular) {
		actions.preencheCelular(celular);
	}

	@Então("clicar em Register")
	public void clicar_em_register() {
		actions.registrarConta();
	}

	@Então("validar que a conta foi criada com sucesso")
	public void validar_que_a_conta_foi_criada_com_sucesso() {
		actions.validaCriacaoDaConta();
	}

	@Então("validar que foi apresentada mensagem de erro")
	public void validar_que_foi_apresentada_mensagem_de_erro() {
		actions.validaMensagemdeErro();
	}

	@Então("devo preencher meu {string} e {string}")
	public void devo_preencher_meu_e(String email, String senha) {
		actions.efetuarLogin(email, senha);
	}

	@Então("validar que a conta foi acessada com sucesso")
	public void validar_que_a_conta_foi_acessada_com_sucesso() {
		actions.validaCriacaoDaConta();
	}
}
