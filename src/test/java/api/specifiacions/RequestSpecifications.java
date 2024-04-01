package api.specifiacions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import objects.UserCreationDTO;

import static api.Properties.BASE_URI;
import static api.Properties.PATH_REGISTRATION;

public class RequestSpecifications {

    RequestSpecification requestSpecification;

    private void createRequestSpecificationRegistration(UserCreationDTO userCreationDTO) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_REGISTRATION)
                .setContentType(ContentType.JSON)
                .setBody(userCreationDTO)
                .build();
    }

}
