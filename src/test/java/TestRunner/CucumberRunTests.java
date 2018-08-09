package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"BasePackage", "LoginPage", "UsersPage"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ApsiyonTestAutomationReport.html"},
        monochrome = true)
public class CucumberRunTests {

}