package web;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	plugin = "pretty" 
					,monochrome = true 
					,dryRun = false 
					,features = "src/test/java/web/featuresCadastroeLogin.feature"
					,glue={"web"}
)
public class WebLocalRunner {

}
