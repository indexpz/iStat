package pl.indexpz.iStat.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class UserLoader implements Loader{

private final UserService userService;

    public UserLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Integer getPriority() {
        return 1;
    }

    @Override
    public String getEntityName() {
        return User.class.getSimpleName();
    }

    @Override
    public Set<Long> createEntities() {
//        userService.save(new User(null, "adam@slodowy.pl", "abc"));
//        userService.save(new User(null, "adam@wp.pl", "cba"));

        List<User> users = userService.findAll();
        log.debug("Created authors count: {}", users.size());
        return users.stream()
                .map(User::getId)
                .collect(Collectors.toSet());
    }
}
