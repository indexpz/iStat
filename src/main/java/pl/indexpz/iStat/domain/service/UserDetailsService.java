package pl.indexpz.iStat.domain.service;


import pl.indexpz.iStat.domain.model.UserDetails;

import java.util.List;

public interface UserDetailsService {

    UserDetails getById(Long id);

    UserDetails add(UserDetails toAdd);

    void update(UserDetails toUpdate);

    void delete(Long id);

    List<UserDetails> getAll();
}
