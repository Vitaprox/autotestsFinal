package api.tests;

import api.steps.DBSteps;
import api.steps.Steps;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTests {

    protected ResponseSpecification responseSpecification;
    protected RequestSpecification requestSpecification;
    protected Steps steps = new Steps();
    protected DBSteps dbSteps = new DBSteps();

}
