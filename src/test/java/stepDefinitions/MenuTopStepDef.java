package stepDefinitions;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObject.AdvancedautopartsPage;

import java.io.IOException;
import java.util.List;

public class MenuTopStepDef extends DriverFactory {
    public WebDriver driver;

    @Given("Open browser and navigate to the {string}")
    public void openBrowserAndNavigateToThe(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
    }

    @When("Get all the Top MenuItems")
    public void getAllTheMenuItems() throws InterruptedException {
        try {
            AdvancedautopartsPage aap = new AdvancedautopartsPage(driver);
            List<WebElement> menuItems = aap.getMenuItem();
            System.out.println("Menu Items");
            for (WebElement menuItem : menuItems) {
                Actions a = new Actions(driver);
                a.moveToElement(menuItem).click().build().perform();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to execute " + this.getClass().getName());
            driver.quit();
        }

    }

    @Then("Close the browsers")
    public void closeTheBrowser() {
        driver.quit();
        System.out.println("Browser added successfully");
    }
}
