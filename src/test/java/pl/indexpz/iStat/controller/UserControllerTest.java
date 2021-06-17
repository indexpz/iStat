package pl.indexpz.iStat.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.indexpz.iStat.controller.dto.UserRequest;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserCreateFormController.class)
class UserControllerTest {


    @Test
    public void postingANewUserShouldCreateANewUserInTheDatabase(){
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@wp.pl");
        userRequest.setPassword("abc1234");
    }

}