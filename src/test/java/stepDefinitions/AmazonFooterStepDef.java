package stepDefinitions;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.AmazonPage;

import java.io.IOException;
import java.util.List;

public class AmazonFooterStepDef extends DriverFactory {
    public WebDriver driver;

    @Given("Open browser and enter url {string}")
    public void openBrowserAndEnterUrl(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
    }

    @When("Get all the footer list")
    public void getAllTheFooterList() {
        try {
            AmazonPage ap = new AmazonPage(driver);
            List<WebElement> footerList = ap.getFooter();
            System.out.println(footerList.size());
            for (WebElement list : footerList) {
                System.out.println(list.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to execute " + this.getClass().getName());
            driver.quit();
        }
    }

    @Then("Close The Browser")
    public void closeTheBrowser() {
        driver.quit();
        System.out.println("Browser added successfully");
    }
}


