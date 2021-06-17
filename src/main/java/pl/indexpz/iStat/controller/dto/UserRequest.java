package pl.indexpz.iStat.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import pl.indexpz.iStat.domain.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRequest {
    @NotEmpty
    private String email;

    private String nickName;

    @NotEmpty
    @Range(min=6, max=20)
        private String password;

    public User toUser(){
        return new User(null, nickName, email, password, null, null);
    }
}
