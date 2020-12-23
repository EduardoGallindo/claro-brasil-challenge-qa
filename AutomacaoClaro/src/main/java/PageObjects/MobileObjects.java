package PageObjects;

import org.openqa.selenium.By;

public class MobileObjects {

	public static final By TituloCalculadoraAndroid = By.xpath("(//android.widget.TextView)[1]");
	public static final By CampoPrimeiroValorAndroid = By.xpath("(//android.widget.EditText)[1]");
	public static final By CampoSegundoValorAndroid = By.xpath("(//android.widget.EditText)[2]");
	public static final By botaoSomaAndroid = By.xpath("//*[@text='SUM']");
	public static final By botaoSubtraiAndroid = By.xpath("//*[@text='SUBTRACT']");
	public static final By botaoMultiplicaAndroid = By.xpath("//*[@text='MULTIPLY']");
	public static final By botaoDivideAndroid = By.xpath("//*[@text='DIVIDE']");
	public static final By CampoResultadoAndroid = By.xpath("(//android.widget.TextView)[2]");
}
