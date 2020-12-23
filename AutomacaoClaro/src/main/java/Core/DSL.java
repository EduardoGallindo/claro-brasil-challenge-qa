package Core;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	WebDriverWait wait;
	WebDriver driver;

	public DSL(WebDriver Driver) {
		this.driver = Driver;
		wait = new WebDriverWait(driver, 3);
	}

	public void selecionarComboAndroid(By by, String valor) {
		driver.findElement(by).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']")).click();
	}

	public boolean isCheckMarcadoAndroid(By by) {
		return driver.findElement(by).getAttribute("checked").equals("true");
	}

	public void acessarSite(String URL) {
		driver.get(URL);
	}

	public void escrever(By by, String texto) {
		for (int j = 0; j < 2; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(by));
				WebElement elemento = driver.findElement(by);
				elemento.click();
				elemento.clear();
				String[] output = texto.split(Pattern.quote(""));
				for (String s : output) {
					elemento.sendKeys(s);
				}
				j = 2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de input");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de input");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public void clicar(By by) {
		for (int j = 0; j < 2; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(by));
				WebElement elemento = driver.findElement(by);
				elemento.click();
				j = 2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de click");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de click");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}
	
	public void selecionarElementoporTexto(By by, String Texto) {
		Select select = new Select(driver.findElement(by));
		select.selectByVisibleText(Texto);
	}
	
	public void selecionarElementoporValor(By by, String Valor) {
		Select select = new Select(driver.findElement(by));
		select.selectByValue(Valor);
	}
	
	public void validaTitulo(String Titulo) {
		assertEquals(Titulo, driver.getTitle());
	}

	public void validaTexto(String Texto, By by) {
		assertEquals(Texto, obterTexto(by));
	}

}
