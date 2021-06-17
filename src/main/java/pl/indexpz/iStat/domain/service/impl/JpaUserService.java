package pl.indexpz.iStat.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.service.UserService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;

@Primary
@Service
@Slf4j
public class JpaUserService implements UserService {

    private final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return (User) userRepository.findAllById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("User with id: %d not exist", id)));
    }

    @Override
    public User add(User toAdd) {
        log.info("Saving User " + toAdd);
        return userRepository.save(toAdd);
    }

    @Override
    public void update(User toUpdate) {
        log.info("Updating user " + toUpdate);
        User user = getById(toUpdate.getId());
        user.setNickName(user.getNickName());
        user.setEmail(user.getEmail());
        user.setEmail(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        log.info("Delete user: " + user);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
