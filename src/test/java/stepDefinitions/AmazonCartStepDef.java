package stepDefinitions;

import Drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.AmazonPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AmazonCartStepDef extends DriverFactory {
    public WebDriver driver;

    @Given("Open browser and enter amazon url {string}")
    public void openBrowserAndEnterAmazonUrl(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
        if (driver.getTitle().contains("Amazon")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @When("Search for product {string} and add to cart and proceed to checkout")
    public void searchForProductAndAddToCartAndProceedToCheckout(String product) throws InterruptedException {
        try {
            AmazonPage ap = new AmazonPage(driver);
            System.out.println("In amazon");
            Thread.sleep(2000);
            ap.SearchBox().sendKeys(product, Keys.ENTER);
            System.out.println("Amazon " + product);
            Thread.sleep(2000);
            List<WebElement> mobiles = ap.getProduct();
            int size = mobiles.size();
            System.out.println("Products  " + size);
            int prod = 0;
            for (WebElement mobile : mobiles) {
                Thread.sleep(3000);
                mobile.click();
                System.out.println("Product click successful");
                Set<String> ids = driver.getWindowHandles();
                Iterator<String> it = ids.iterator();
                String parentId = it.next();
                String childId = it.next();
                driver.switchTo().window(childId);
                ap.addToCart().click();
                prod++;
                System.out.println("Prod count: " + prod + "Size: " + size);
                Thread.sleep(1000);
                if (prod == size) {
                    ap.proceedToCheckOut().click();
                    System.out.println("Proceed to checkout");
                }
                driver.close();
                driver.switchTo().window(parentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to execute " + this.getClass().getName());
            driver.quit();
        }


    }

    @Then("Close all opened browsers")
    public void closeAllOpenedBrowsers() {
        driver.quit();
        System.out.println("Browser added successfully");
    }


}
