package pl.indexpz.iStat.controller.converter;

import org.springframework.stereotype.Component;
import pl.indexpz.iStat.controller.dto.EditUserForm;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.repository.VehicleRepository;

import javax.swing.text.EditorKit;
import java.util.Optional;

@Component
public class UserConverter {

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public UserConverter(UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }


    public User from(EditUserForm data) {
        User user = new User();
        user.setId(data.getId());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        return user;
    }

    public EditUserForm toUser(User user) {
        EditUserForm data = new EditUserForm();
        data.setId(user.getId());
        data.setFirstName(user.getFirstName());
        data.setLastName(user.getLastName());
        return data;

    }
}
