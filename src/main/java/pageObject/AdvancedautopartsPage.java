package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdvancedautopartsPage {

    public WebDriver driver;
    By addVehicle = By.xpath("//div[text()='Add a vehicle']");
    By ymm = By.xpath("//div[text()='Year / Make / Model']");
    By options = By.xpath("//div[@class=' css-1hwfws3']//following::div[5]");
    By add = By.xpath("//div[text()='Add']");
    By menuItems = By.xpath("//li[@class='css-vurnku']");
    By products = By.xpath("//div/h2[contains(text(),'SELLERS')]/following::div[5] //div[@class='css-16ljpqv']");
    By amounts = By.xpath("//div/h2[contains(text(),'SELLERS')]/following::div[5] //div[@class='css-i7u5km']");
    By arrow = By.xpath("//*[@class='primary css-1gw8ayk']");
    By shopAll = By.xpath("//div[text()='Shop All']");
    By more = By.xpath("//div[text()='Exhaust']/following::button[text()='More']");
    By exhaustMenu = By.xpath("//div[@class='css-vurnku']/a[contains(@href,'exhaust')]");

    public AdvancedautopartsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> exhaustMenu() {

        return driver.findElements(exhaustMenu);
    }

    public WebElement more() {

        return driver.findElement(more);
    }

    public WebElement shopAll() {

        return driver.findElement(shopAll);
    }

    public WebElement getArrow() {

        return driver.findElement(arrow);
    }

    public WebElement addVehicle() {

        return driver.findElement(addVehicle);
    }

    public WebElement addVehicleOption() {

        return driver.findElement(ymm);
    }

    public WebElement getOptions() {
        return driver.findElement(options);
    }

    public List<WebElement> getMenuItem() {

        return driver.findElements(menuItems);
    }

    public List<WebElement> getProducts() {

        return driver.findElements(products);
    }

    public List<WebElement> getAmounts() {

        return driver.findElements(amounts);
    }

    public WebElement add() {

        return driver.findElement(add);
    }

}
