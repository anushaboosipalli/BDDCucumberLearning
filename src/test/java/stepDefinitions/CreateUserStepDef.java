package stepDefinitions;

import apiController.ReqResController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;


public class CreateUserStepDef {
    ReqResController controller = new ReqResController();
    private String path = "";
    private Response response;

    @Given("create user endpoint")
    public void create_user_endpoint() {
        path = "/api/users";
    }

    @When("hits create user endPoint with name {string} and job {string}")
    public void hits_create_user_end_point(String name, String job) {
        response = controller.hitsCreateUser(path, name, job);
    }

    @Then("expected status code is {int}")
    public void expected_status_code_is(Integer expectedCode) {
        Assert.assertTrue(response.getStatusCode() == expectedCode);
        System.out.println("status code is expected");
    }


}
