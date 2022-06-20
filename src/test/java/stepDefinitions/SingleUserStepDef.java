package stepDefinitions;

import apiController.ReqResController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class SingleUserStepDef {
    ReqResController controller = new ReqResController();
    String path = "";
    Response response;

    @Given("single User endPoint")
    public void single_user_end_point() {
        path = "/api/users/";
    }

    @When("hits single user endPoint with id {string}")
    public void hits_single_user_end_point_with_id(String id) {
        response = controller.hitsSingleUserEndPointWithId(path, id);
    }

    @When("hits Single user endPoint with non-existent id")
    public void hits_single_user_end_point_with_non_existent_id() {
//		 response=controller.hitsSingleUserEndPointWithId(path, id);

    }

    @Then("response code should be {int}")
    public void response_code_should_be(Integer expectedCode) {
        Assert.assertTrue(response.getStatusCode() == expectedCode);
    }

    @Then("id in the response should be {string}")
    public void id_in_the_response_should_be(String id) {
        System.out.println(response.jsonPath().get("data.id").toString());
        Assert.assertEquals(response.jsonPath().get("data.id").toString(), id);

    }


}
