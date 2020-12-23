package mobile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	plugin = "pretty" 
					,monochrome = true 
					,dryRun = false 
					,features = "src/test/java/mobile/featuresCalculadoraAndroidBrowserStack.feature"
					,glue={"mobile"}
)
public class MobileBrowserStackRunner {

}
