package objects;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
public class User {

    private String login;
    private String password;
    private String email;
    private List<Role> roles;

    public User generateUser() {
        int numberGenerate =  100 + (int) (Math.random() * 10000);

        User newUser = new User();
        newUser.setLogin("test_login10" + numberGenerate);
        newUser.setPassword("123");
        newUser.setEmail("text" + numberGenerate + "@login.ru");
        newUser.setDefaultRole();
        return newUser;
    }

    public void setDefaultRole() {
        Role defaultRole = new Role();
        defaultRole.setId(2);
        defaultRole.setName("ROLE_USER");

        List<Role> defaultListRole = new ArrayList<>();
        defaultListRole.add(defaultRole);

        this.roles = defaultListRole;
    }

    public void setRole(int id, String name) {
        Role role = new Role();
        role.setId(id);
        role.setName(name);

        if (Objects.isNull(this.roles)) {
            List<Role> listRole = new ArrayList<>();
            listRole.add(role);
            this.roles = listRole;
        } else {
            this.roles.add(role);
        }
    }

}
