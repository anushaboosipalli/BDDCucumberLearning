package stepDefinitions;

import Drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.TopSellerRequestMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObject.AdvancedautopartsPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TopSellersStepDef extends DriverFactory {

    public TopSellerRequestMethod ts;
    public AdvancedautopartsPage aap;
    public WebDriver driver;

    @Given("Open browser and navigate to the aap {string}")
    public void openBrowserAndNavigateToTheAap(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
    }

    @When("Scroll down to Top Sellers")
    public void scrollDownToTopSellers() {
        ts = new TopSellerRequestMethod(driver);
        ts.scrollDown(driver);
    }

    @And("Get the Top Sellers")
    public void getTheTopSellers() throws InterruptedException {
        try {
            aap = new AdvancedautopartsPage(driver);
            Thread.sleep(8000);
            List<WebElement> products = aap.getProducts();
            System.out.println("No.of products " + products.size());
            List<WebElement> amounts = aap.getAmounts();
            System.out.println("No of Values " + amounts.size());
            HashMap<String, String> map = new HashMap<String, String>();
            int num = 0;
            for (int i = 0; i < amounts.size(); i++) {
                String key = amounts.get(i).getText();
                String value = products.get(i).getText();
                System.out.println("Key :" + key + " Value :" + value);
                map.put(key, value);
                num++;
                if (num == 4) {
                    Thread.sleep(3000);
                    Actions a1 = new Actions(driver);
                    a1.moveToElement(amounts.get(i)).build().perform();
                    WebElement arrow = aap.getArrow();
                    Thread.sleep(3000);
                    System.out.println(arrow.isDisplayed());
                    System.out.println("Clicked on arrow");
                    arrow.click();
                    Thread.sleep(3000);
                }
            }
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to execute " + this.getClass().getName());
            driver.quit();
        }

    }


    @Then("Close all the opened browsers")
    public void closeTheBrowser() {
        driver.quit();
        System.out.println("Browsers closed successfully");
    }
}
