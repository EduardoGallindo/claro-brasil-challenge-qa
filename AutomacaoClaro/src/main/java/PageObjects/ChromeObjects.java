package PageObjects;

import org.openqa.selenium.By;

public class ChromeObjects {

	public static final By botaoSignIn = By.xpath("//a[@title='Log in to your customer account']");
	public static final By campoEmailCriação = By.xpath("//input[@name='email_create']");
	public static final By botaoCriarConta = By.id("SubmitCreate");
	public static final By textoCriarConta = By
			.xpath("//h1[contains(text(),'Create an account') and @class='page-heading']");
	public static final By campoEmailLogin = By.xpath("(//input[@name='email'])[1]");
	public static final By campoSenhaLogin = By.xpath("//input[@name='passwd']");
	public static final By botaoLogin = By.id("SubmitLogin");

//	Seção Dados Pessoais
	public static final By botaoTitulo = By.xpath("//input[contains(@name,'id_gender') and @value='1']");
	public static final By campoNomeInfoPessoal = By.id("customer_firstname");
	public static final By campoSobrenomeInfoPessoal = By.id("customer_lastname");
	public static final By campoSenha = By.id("passwd");
	public static final By selecionarDiaNasc = By.id("days");
	public static final By selecionarMesNasc = By.id("months");
	public static final By selecionarAnoNasc = By.id("years");

//	Seção Endereço
	public static final By campoNomeEndereço = By.id("firstname");
	public static final By campoSobrenomeEndereço = By.id("lastname");
	public static final By campoEndereço = By.id("address1");
	public static final By campoCidade = By.id("city");
	public static final By selecionarEstado = By.id("id_state");
	public static final By campoCEP = By.id("postcode");
	public static final By selecionarPaís = By.id("id_country");
	public static final By campoCelular = By.id("phone_mobile");
	public static final By botaoRegistrar = By.id("submitAccount");
	public static final By mensagemErroCadastro = By.xpath(
			"//*[contains(text(),'An account using this email address has already been registered. Please enter a valid password or request a new one. ')]");
//	Seção Minha Conta
	public static final By textoMinhaConta = By.xpath("//h1[contains(text(),'My account') and @class='page-heading']");
}
