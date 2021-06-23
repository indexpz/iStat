package pl.indexpz.iStat.domain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthenticationService{

private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public void updateUserPassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }


}
