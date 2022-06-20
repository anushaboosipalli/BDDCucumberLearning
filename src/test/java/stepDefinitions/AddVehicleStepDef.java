package stepDefinitions;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageObject.AdvancedautopartsPage;

import java.io.IOException;
import java.time.Duration;

public class AddVehicleStepDef extends DriverFactory {
    public WebDriver driver;

    @Given("Open browser and navigate to {string}")
    public void openBrowserAndNavigateTo(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
    }

    @When("User Add Vehicle Year {string} and Make {string} and Model {string} and Engine {string}")
    public void addVehicleYearAndMakeAndModel(String year, String make, String model, String engine) throws InterruptedException {
        try {
            AdvancedautopartsPage aap = new AdvancedautopartsPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(3000);
            aap.addVehicle().click();
            Thread.sleep(3000);
            aap.addVehicleOption().click();
            Thread.sleep(3000);
            aap.getOptions().click();
            Thread.sleep(5000);
            driver.switchTo().activeElement().sendKeys(year + Keys.ENTER);
            Thread.sleep(5000);
            driver.switchTo().activeElement().sendKeys(make + Keys.ENTER);
            Thread.sleep(5000);
            driver.switchTo().activeElement().sendKeys(model + Keys.ENTER);
            Thread.sleep(5000);
            driver.switchTo().activeElement().sendKeys(engine + Keys.ENTER);
            Thread.sleep(5000);
            System.out.println("Options added successfully ");
            aap.add().click();
            System.out.println("Vehicle added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to execute " + this.getClass().getName());
            driver.quit();
        }
    }

    @Then("Close browsers")
    public void closeTheBrowser() {
        driver.quit();
        System.out.println("Browser added successfully");
    }
}
