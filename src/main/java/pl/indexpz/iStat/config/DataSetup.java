package pl.indexpz.iStat.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.model.UserDetails;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.service.UserDetailsService;
import pl.indexpz.iStat.domain.service.UserService;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.domain.service.VehicleService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
public class DataSetup {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final VehicleService vehicleService;
    private final VehicleRecordService vehicleRecordService;

    public DataSetup(UserService userService, UserDetailsService userDetailsService, VehicleService vehicleService, VehicleRecordService vehicleRecordService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.vehicleService = vehicleService;
        this.vehicleRecordService = vehicleRecordService;
    }


    @PostConstruct
    @Transactional
    public void setUpData() {
        createIfNotExist(1L, "User1", "user1@test.pl", "pass1234");
        createIfNotExist(2L, "User2", "user2@test.pl", "pass1234");
        createIfNotExist(3L, "User3", "user3@test.pl", "pass1234");
    }


    private void createIfNotExist(Long id, String nickName, String email, String password) {
        try {
            userService.getById(id);
            log.debug("User with id: {} allredy exist in db. No need to add", id);
        } catch (ResourceNotFoundException e) {
            User user = new User(null, nickName, email, password);
            userService.add(user);
            log.debug("User added to db: {}", user);
        }
    }


}
