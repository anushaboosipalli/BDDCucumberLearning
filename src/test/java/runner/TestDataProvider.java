package runner;

import Utility.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestDataProvider {

    @Test(dataProvider = "getData")
    public void getLoginTestData(String username, String password) {
        System.out.println("Username " + username + " Password " + password);
        String user = username.split("un")[1].trim();
        String pwd = password.split("pw")[1].trim();
        if (user.equals(pwd)) {
            System.out.println("Combinations are valid");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
            System.out.println("Combinations are invalid");
        }
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        ExcelUtility util = new ExcelUtility();
        Object data[][] = util.getXcelData();
        return data;
    }

}
