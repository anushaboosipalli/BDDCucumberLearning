package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObject.AdvancedautopartsPage;

import java.util.ArrayList;
import java.util.List;

public class TopSellerRequestMethod {
    public WebDriver driver;
    public AdvancedautopartsPage aap;

    public TopSellerRequestMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1700)", "");
    }

    public List<String> getKey(List<WebElement> products, WebDriver driver) throws InterruptedException {
        int num = 0;
        List<String> key = new ArrayList<String>();
        for (WebElement product : products) {
            key.add(product.getText());
            num++;
            if (num == 4) {
                Thread.sleep(3000);
                Actions a1 = new Actions(driver);
                a1.moveToElement(product).build().perform();
                Thread.sleep(3000);
                WebElement arrow = driver.findElement(By.xpath("//*[@class='primary css-1gw8ayk']"));
                Thread.sleep(3000);
                System.out.println(arrow.isDisplayed());
                arrow.click();
                Thread.sleep(3000);
            }
        }
        System.out.println("Product" + key);
        return key;
    }

    public List<String> getValue(List<WebElement> amounts, WebDriver driver, AdvancedautopartsPage aap) throws InterruptedException {
        int num = 0;

        List<String> value = new ArrayList<String>();
        for (WebElement amount : amounts) {
            value.add(amount.getText());
            num++;
            if (num == 4) {
                Thread.sleep(3000);
                Actions a1 = new Actions(driver);
                a1.moveToElement(amount).build().perform();
                WebElement arrow = driver.findElement(By.xpath("//*[@class='primary css-1gw8ayk']"));
                Thread.sleep(3000);
                System.out.println(arrow.isDisplayed());
                arrow.click();
                Thread.sleep(3000);
            }
        }
        System.out.println("amount" + value);
        return value;
    }
}
