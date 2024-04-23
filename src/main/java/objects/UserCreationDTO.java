package objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreationDTO {

    private String login;
    private String password;
    private String email;
    private List<Role> roles;
}
