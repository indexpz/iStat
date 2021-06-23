package pl.indexpz.iStat.domain.service;

import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.User;

public interface UserService {

    User getUserById(Long userId);

    User getUserByUserName(String username);

    void updateUser(User userToUpdate);

    void updateUserName(User userToUpdate);

    void updateUserPassword(User userToUpdatePassword);

    public void delete(User userToDelete);
}
