package pl.indexpz.iStat.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.model.UserDetails;
import pl.indexpz.iStat.domain.repository.UserDetailsRepository;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.service.UserDetailsService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;

@Primary
@Service
@Slf4j
public class JpaUserDetailsService implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public JpaUserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetails getById(Long id) {
        return (UserDetails) userDetailsRepository.findAllById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("User with id: %d not exist", id)));
    }

    @Override
    public UserDetails add(UserDetails toAdd) {
        log.info("Saving userDetails " + toAdd);
        return userDetailsRepository.save(toAdd);
    }

    @Override
    public void update(UserDetails toUpdate) {
        log.info("Updating user " + toUpdate);
        UserDetails userDetails = getById(toUpdate.getId());
        userDetails.setFirstName(userDetails.getFirstName());
        userDetails.setLastName(userDetails.getLastName());
        userDetails.setStreet(userDetails.getStreet());
        userDetails.setStreet(userDetails.getStreet());
        userDetails.setStreetNumber(userDetails.getStreetNumber());
        userDetails.setApartmentNumber(userDetails.getApartmentNumber());
        userDetails.setPostalCode(userDetails.getPostalCode());
        userDetails.setCity(userDetails.getCity());
        userDetailsRepository.save(userDetails);
    }

    @Override
    public void delete(Long id) {
        UserDetails userDetails = getById(id);
        log.info("Delete user: " + userDetails);
        userDetailsRepository.delete(userDetails);
    }

    @Override
    public List<UserDetails> getAll() {
        return userDetailsRepository.findAll();
    }
}
