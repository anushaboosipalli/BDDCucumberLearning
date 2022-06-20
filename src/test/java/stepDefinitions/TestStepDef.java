package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TestStepDef {


    @Given("sheetname {string} and rownumber {string}")
    public void sheetnameAndRownumber(String arg0, String arg1) {
        System.out.println(arg0 + arg1);
    }
}
