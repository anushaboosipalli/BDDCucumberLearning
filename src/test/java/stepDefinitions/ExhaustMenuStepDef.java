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

public class ExhaustMenuStepDef extends DriverFactory {
    public WebDriver driver;
    public AdvancedautopartsPage aap;

    @Given("Open browser and navigate app {string}")
    public void openBrowserAndNavigateApp(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
    }

    @When("Navigate form ShopAll to Exhaust menu")
    public void navigateFormShopAllToExhaustMenu() {
        try {
            aap = new AdvancedautopartsPage(driver);
            WebElement shopAll = aap.shopAll();
            Actions a = new Actions(driver);
            a.moveToElement(shopAll).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to execute " + this.getClass().getName());
            driver.quit();
        }

    }

    @Then("Click on more and get The Exhaust Menu list")
    public void clickOnMoreAndGetTheExhaustMenuList() throws InterruptedException {
        aap = new AdvancedautopartsPage(driver);
        aap.more().click();
        Thread.sleep(2000);
        List<WebElement> exhaustMenu = aap.exhaustMenu();
        int s = exhaustMenu.size();
        System.out.println("Size of exhaust menu list is " + s);
        for (int i = 0; i < s; i++) {
            System.out.println(exhaustMenu.get(i).getText());
        }

    }

    @Then("Close the browser")
    public void closeTheBrowser() {
        driver.quit();
        System.out.println("Browser added successfully");
    }
}
