package Actions;

import org.openqa.selenium.WebDriver;

import Core.DSL;
import PageObjects.ChromeObjects;

public class ChromeActions {

	WebDriver driver;
	private String dia;
	private String mes;
	private String ano;
	DSL dsl;

	public ChromeActions(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}

	public void preencheEmailCriacao(String email) {
		dsl.clicar(ChromeObjects.botaoSignIn);
		dsl.escrever(ChromeObjects.campoEmailCriação, email);
		dsl.clicar(ChromeObjects.botaoCriarConta);
	}

	public void preencheDadosPessoais(String nome, String sobrenome, String datanasc) {
		dsl.clicar(ChromeObjects.botaoTitulo);
		dsl.escrever(ChromeObjects.campoNomeInfoPessoal, nome);
		dsl.escrever(ChromeObjects.campoSobrenomeInfoPessoal, sobrenome);
//		Formata a data de nascimento
		dia = datanasc.substring(0, 2);
		mes = datanasc.substring(3, 5);
		ano = datanasc.substring(6, 10);
		int Dia = Integer.parseInt(dia);
		dia = String.valueOf(Dia);
		int Mes = Integer.parseInt(mes);
		mes = String.valueOf(Mes);
		dsl.selecionarElementoporValor(ChromeObjects.selecionarDiaNasc, dia);
		dsl.selecionarElementoporValor(ChromeObjects.selecionarMesNasc, mes);
		dsl.selecionarElementoporValor(ChromeObjects.selecionarAnoNasc, ano);
	}

	public void preencheSenha(String senha) {
		dsl.escrever(ChromeObjects.campoSenha, senha);
	}

	public void preencheEndereço() {
		dsl.escrever(ChromeObjects.campoEndereço, "3371 S Alabama Ave");
		dsl.escrever(ChromeObjects.campoCidade, "Monroeville");
		dsl.selecionarElementoporTexto(ChromeObjects.selecionarEstado, "Alabama");
		dsl.escrever(ChromeObjects.campoCEP, "36460");
		dsl.selecionarElementoporTexto(ChromeObjects.selecionarPaís, "United States");
	}

	public void preencheCelular(String celular) {
		dsl.escrever(ChromeObjects.campoCelular, celular);
	}

	public void registrarConta() {
		dsl.clicar(ChromeObjects.botaoRegistrar);
	}

	public void validaCriacaoDaConta() {
		dsl.validaTitulo("My account - My Store");
		dsl.validaTexto("MY ACCOUNT", ChromeObjects.textoMinhaConta);
	}

	public void validaMensagemdeErro() {
		dsl.validaTexto(
				"An account using this email address has already been registered. Please enter a valid password or request a new one.",
				ChromeObjects.mensagemErroCadastro);
	}

	public void efetuarLogin(String email, String senha) {
		dsl.clicar(ChromeObjects.botaoSignIn);
		dsl.escrever(ChromeObjects.campoEmailLogin, email);
		dsl.escrever(ChromeObjects.campoSenhaLogin, senha);
		dsl.clicar(ChromeObjects.botaoLogin);
	}

}
