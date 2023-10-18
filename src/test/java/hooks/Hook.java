package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Hook {
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario){

        driver = DriverFactory.intitializeDriver();
    }
    @After
    public void tearDown(Scenario scenario){
        System.out.println("Scenario: "+ scenario.getName() + " has " + scenario.getStatus());
        driver.quit();
    }
}
