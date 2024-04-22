package api.tests;

import api.steps.DBSteps;
import api.steps.Steps;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import objects.User;
import objects.UserCreationDTO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

@DisplayName("Проверка авторизации API")
public class TestsAuthorization {

    private Steps steps = new Steps();
    private DBSteps dbSteps = new DBSteps();
    private ResponseSpecification responseSpecification;
    private RequestSpecification requestSpecification;
    private User newUser;


    @BeforeEach
    public void before(){
        newUser = new User().generateUser();
        dbSteps.createUserWithStandardPassword(newUser.getLogin());
    }

    @AfterEach
    public void after(){
        dbSteps.fullDeleteUser(newUser.getLogin());
    }


    @Test
    @DisplayName(value = "Проверка успешной авторизации")
    public void SuccessfulAuthorizationTest() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("password", newUser.getPassword());
        formParams.put("username", newUser.getLogin());

        requestSpecification = steps.createRequestSpecificationAuthorization(formParams);
        responseSpecification = steps.createResponseSpecificationRegistration(200);
        steps.getAuthorization(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка авторизации только с паролем")
    public void AuthorizationWithoutLoginTest() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("password", newUser.getPassword());

        requestSpecification = steps.createRequestSpecificationAuthorization(formParams);
        responseSpecification = steps.createResponseSpecificationRegistration(403);
        steps.getAuthorization(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка авторизации только с логином")
    public void AuthorizationWithoutPasswordTest() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("username", newUser.getLogin());

        requestSpecification = steps.createRequestSpecificationAuthorization(formParams);
        responseSpecification = steps.createResponseSpecificationRegistration(403);
        steps.getAuthorization(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка авторизации без логина и пароля")
    public void AuthorizationWithoutLoginAndPasswordTest() {
        Map<String, String> formParams = new HashMap<>();

        requestSpecification = steps.createRequestSpecificationAuthorization(formParams);
        responseSpecification = steps.createResponseSpecificationRegistration(403);
        steps.getAuthorization(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка авторизации с неправильными логином и паролем")
    public void AuthorizationWithWrongLoginAndPasswordTest() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("password", "asfaksfalsfaslkgnaslfasasgsagfas");
        formParams.put("username", "asfaksfalsfaslkgasgshasfgnaslfasasgsagfas");

        requestSpecification = steps.createRequestSpecificationAuthorization(formParams);
        responseSpecification = steps.createResponseSpecificationRegistration(403);
        steps.getAuthorization(requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка авторизации с неправильными логином и паролем")
    public void AuthorizationWithTrueLoginAndWrongPasswordTest() {

        Map<String, String> formParams = new HashMap<>();
        formParams.put("password", "asfaksfalsfaslkgnaslfasasgsagfas");
        formParams.put("username", newUser.getLogin());

        requestSpecification = steps.createRequestSpecificationAuthorization(formParams);
        responseSpecification = steps.createResponseSpecificationRegistration(403);
        steps.getAuthorization(requestSpecification, responseSpecification);
    }

}
