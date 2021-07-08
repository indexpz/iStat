package pl.indexpz.iStat.controller.dto;

import lombok.Data;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.model.Vehicle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreateUserForm {
    @Email
    @NotBlank
    private String username;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String password;
//    private String role = "ROLE_USER";
//    private List<Vehicle> userVehicles = new ArrayList<>();


    public User toUser() {
        return new User(null, username, firstName, lastName, password, null, null);
    }
}
