package pl.indexpz.iStat.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserEditForm {

    @NotNull
    private Long id;
    @NotBlank
    private String nickName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;


}
