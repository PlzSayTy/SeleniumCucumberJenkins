import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(features = {"src/main/resources/"}, glue = {"ru"},
            plugin = {
                    "ru.Utils.AllureReporter",
            }
    )
    public class CucumberRunner {


    }
