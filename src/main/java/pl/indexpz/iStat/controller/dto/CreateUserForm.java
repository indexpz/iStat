package pl.indexpz.iStat.controller.dto;

import lombok.Data;
import pl.indexpz.iStat.domain.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateUserForm {
    @Email
    @NotBlank
    private String userName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String password;


    public User toUser(){
        return new User(null, userName, firstName, lastName, password, null ,null);
    }
}
