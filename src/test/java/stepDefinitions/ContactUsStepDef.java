package stepDefinitions;

import Drivers.DriverFactory;
import Utility.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUsStepDef extends DriverFactory {
    public WebDriver driver;

    @Given("user navigates to contact us page {string}")
    public void userNavigatesToContactUsPage(String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
        Assert.assertEquals("Contact us - My Store", driver.getTitle());
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void userFillsDataFromExcelSheetAndRownumberRownumber(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
        ExcelReader excelReader = new ExcelReader();
        //int rowNumber= Integer.parseInt(rowNum);
        System.out.println("SheetName: "+sheetName+" RowNumber: "+rowNumber);
        List<Map<String, String>> testData = excelReader.getData("C:\\Users\\anusha.b20\\Documents\\Automation.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("Subjectheading");
        String email = testData.get(rowNumber).get("Email");
        String orderref = testData.get(rowNumber).get("orderref");
        String message = testData.get(rowNumber).get("message");
        System.out.println("SubjectHeading: " + heading + " Email: " + email + " Ordereference: " +
                orderref + " message: " + message);
        WebElement element = driver.findElement(By.id("id_contact"));
        Select options = new Select(element);
        options.selectByVisibleText(heading);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("id_order")).sendKeys(orderref);
        driver.findElement(By.name("message")).sendKeys(message);
    }

    @And("user clicks on send button")
    public void clicksOnVerifyButton() {
        driver.findElement(By.id("submitMessage")).click();
        System.out.println("User submitted successfully");
    }

    @Then("it shows a successful message {string}")
    public void verifyTheUserMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
        System.out.println("expectedMessage "+actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);
        System.out.println("Message verification successfully");
        driver.quit();
    }



}
