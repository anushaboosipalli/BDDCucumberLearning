package apiController;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class ReqResController {

    public Response hitsSingleUserEndPointWithId(String path, String id) {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given().log().all();
        Response response = request.basePath(path + id).get();
        System.out.println("response " + response.getStatusCode());
        return response;

    }

    public Response hitsCreateUser(String path, String name, String job) {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given().log().all();
//		CreateUserRequestModel model=CreateUserRequestMockup.createUser(name, job);
//		Gson gson = new GsonBuilder().create();
//        JSONObject requestBody = new JSONObject(gson.toJson(model));
        JSONObject model = new JSONObject();
        model.put("name", name);
        model.put("job", job);
        Response response = request.basePath(path).body(model.toString()).post();
        System.out.println("response " + response.getStatusCode());
        return response;

    }

}
