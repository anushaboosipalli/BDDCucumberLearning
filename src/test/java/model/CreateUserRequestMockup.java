package model;

public class CreateUserRequestMockup {

    public static CreateUserRequestModel createUser(String name, String job) {
        CreateUserRequestModel model = new CreateUserRequestModel();
        model.job = name;
        model.name = job;
        return model;
    }


}
