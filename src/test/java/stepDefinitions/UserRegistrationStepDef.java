package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class UserRegistrationStepDef {

    @When("User login to application")
    public void inRegisterEnterUserDetails() {
    }

    @When("When User enters valid credentials")
    public void entersValidCredential(DataTable dataTable) throws InterruptedException{

//        List<List<String>> dataList=dataTable.asLists();
//        for(List<String> list:dataList){
//            System.out.println(list);
//        }

        List<Map<String,String>> dataList =dataTable.asMaps();
        System.out.println(dataList);
    }

    @Then("User registration successful")
    public void userRegistrationSuccessful() {
    }
}
