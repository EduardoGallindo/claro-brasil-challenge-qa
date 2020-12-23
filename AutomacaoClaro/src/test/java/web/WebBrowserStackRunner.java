package web;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	plugin = "pretty" 
					,monochrome = true 
					,dryRun = false 
					,features = "src/test/java/web/featuresCadastroeLoginBrowserStack.feature"
					,glue={"web"}
//					,tags="CT01"
)
public class WebBrowserStackRunner {

}
