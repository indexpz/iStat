package pl.indexpz.iStat.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.service.UserService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class JpaUserService implements UserService {

    private final UserRepository userRepository;


//    String username = SecurityContextHolder.getContext().getAuthentication().getName();


    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow((() -> new ResourceNotFoundException("User with username " + username + " not exist.")));
    }

    @Secured("isAuthenticated()")
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getByUsername(username);
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow((() -> new ResourceNotFoundException("User with id " + userId + " not exist.")));
    }

    @Override
    public void updateUser(User userToUpdate) {
        //TODO Bardzo dobrze, że we wszystkich operacjach użytkownik jest najpierw pobierany
        log.info("UserID to update " + userToUpdate.getId());
        log.info("User to update " + userToUpdate);
        User user = getUserByUserName(userToUpdate.getUsername());
        user.setFirstName(userToUpdate.getFirstName());
        user.setLastName(userToUpdate.getLastName());
        userRepository.save(user);
        log.info("User after update " + user);
    }

    @Override
    public void updateUserName(User userToUpdate) {
        log.info("UserID to update " + userToUpdate.getId());
        log.info("User to update " + userToUpdate);
        User user = getUserById(userToUpdate.getId());
        user.setUsername(userToUpdate.getUsername());
        userRepository.save(user);
        log.info("User after update " + user);
    }

    @Override
    public void updateUserPassword(User userToUpdatePassword) {
        User user = getUserByUserName(userToUpdatePassword.getUsername());
        user.setPassword(userToUpdatePassword.getPassword());
        userRepository.save(user);
    }


    @Override
    public void delete(User userToDelete) {
        User user = getUserByUserName(userToDelete.getUsername());
        log.info("Deleting user: " + user);
        userRepository.delete(user);
    }
}
