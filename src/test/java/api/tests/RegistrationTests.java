package api.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import objects.User;
import objects.UserCreationDTO;

@DisplayName("Проверка регистрации API")
public class RegistrationTests extends BaseTests{

    private UserCreationDTO userCreationDTO;
    private User newUser;

    @BeforeEach
    public void before(){
        newUser = new User().generateUser();
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с обязательными полями")
    public void registrationWithRequiredFieldsTest() {
        userCreationDTO = UserCreationDTO.builder().login(newUser.getLogin())
                .password(newUser.getPassword())
                .build();

        requestSpecification = steps.createRequestSpecificationRegistration(userCreationDTO);
        responseSpecification = steps.createResponseSpecificationRegistration(201);
        steps.postRegistration(requestSpecification, responseSpecification);
        dbSteps.fullDeleteUser(newUser.getLogin());
    }

    @Test
    @DisplayName(value = "Проверка регистрации со всеми полями")
    public void registrationWithAllFieldsTest() {
        UserCreationDTO userCreationDTO = UserCreationDTO.builder().login(newUser.getLogin())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .roles(newUser.getRoles())
                .build();

        requestSpecification = steps.createRequestSpecificationRegistration(userCreationDTO);
        responseSpecification = steps.createResponseSpecificationRegistration(201);
        steps.postRegistration(requestSpecification, responseSpecification);
        dbSteps.fullDeleteUser(newUser.getLogin());
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с отправкой логина")
    public void registrationOnlyWithLoginTest() {
        userCreationDTO = userCreationDTO.builder().login(newUser.getLogin()).build();

        requestSpecification = steps.createRequestSpecificationRegistration(userCreationDTO);
        responseSpecification = steps.createResponseSpecificationRegistration(500);
        steps.postRegistrationFail("Password is required", requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с отправкой пароля")
    public void registrationOnlyWithPasswordTest() {
        userCreationDTO = userCreationDTO.builder().password(newUser.getPassword()).build();

        requestSpecification = steps.createRequestSpecificationRegistration(userCreationDTO);
        responseSpecification = steps.createResponseSpecificationRegistration(500);
        steps.postRegistrationFail("Login is required", requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с почтой")
    public void registrationOnlyWithEmailTest() {
        userCreationDTO = userCreationDTO.builder().email(newUser.getEmail()).build();

        requestSpecification = steps.createRequestSpecificationRegistration(userCreationDTO);
        responseSpecification = steps.createResponseSpecificationRegistration(500);
        steps.postRegistrationFailWithContainsMessages("Login is required", "Password is required", requestSpecification, responseSpecification);
    }

    @Test
    @DisplayName(value = "Проверка регистрации со всеми пустыми полями")
    public void registrationOnlyWithoutFieldsTest() {
        userCreationDTO = userCreationDTO.builder().build();

        requestSpecification = steps.createRequestSpecificationRegistration(userCreationDTO);
        responseSpecification = steps.createResponseSpecificationRegistration(500);
        steps.postRegistrationFailWithContainsMessages("Login is required", "Password is required", requestSpecification, responseSpecification);
    }

}
