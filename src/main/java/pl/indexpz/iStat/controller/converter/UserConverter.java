package pl.indexpz.iStat.controller.converter;

import org.springframework.stereotype.Component;
import pl.indexpz.iStat.controller.dto.UserEditForm;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserDetailsRepository;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.Optional;

@Component
public class UserConverter {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    public UserConverter(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    public User from(UserEditForm data){
        User user = new User();
        user.setId(data.getId());
        user.setNickName(data.getNickName());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        return user;
    }


    public UserEditForm toUserEditForm(User user){
        UserEditForm data = new UserEditForm();
        data.setId(user.getId());
        data.setNickName(user.getNickName());
        data.setEmail(user.getEmail());
        data.setPassword(user.getPassword());
        return data;
    }

}
