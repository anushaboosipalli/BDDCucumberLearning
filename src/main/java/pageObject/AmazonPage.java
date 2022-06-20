package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonPage {
    public WebDriver driver;
    By footer = By.xpath("//tbody/tr/td/a");
    By searchBox = By.cssSelector("input[id='twotabsearchtextbox']");
    //By product = By.xpath("//a[contains(@href,'Apple-iPhone')]/span[contains(text(),'Apple iPhone')]");
    By cart = By.id("add-to-cart-button");
    By checkOut = By.xpath("//*[@id='attach-sidesheet-checkout-button']/span/input");
    By product = By.xpath("//div[@class='a-section'] //span[contains(text(),'Apple iPhone 13 Pro')]");

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getFooter() {

        return driver.findElements(footer);
    }

    public WebElement SearchBox() {

        return driver.findElement(searchBox);
    }

    public List<WebElement> getProduct() {
        System.out.println("In getProduct");
        return driver.findElements(product);
    }

    public WebElement addToCart() {

        return driver.findElement(cart);
    }

    public WebElement proceedToCheckOut() {

        return driver.findElement(checkOut);
    }


}
