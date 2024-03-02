package payment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-html-report"},
    features = {"classpath:features"},
    glue = { "payment" }
)
public class CucumberIT {
}

