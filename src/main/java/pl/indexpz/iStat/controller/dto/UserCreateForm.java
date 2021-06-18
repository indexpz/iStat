package pl.indexpz.iStat.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import pl.indexpz.iStat.domain.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class UserCreateForm {
//    @Range(min = 2, max = 12)
    private String nickName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
//    @Range(min = 3, max = 20)
    private String password;

    public User toUser() {
        return new User(null, nickName, email, password);
    }
}
