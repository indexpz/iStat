package pl.indexpz.iStat.domain.service;


import pl.indexpz.iStat.domain.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    User add(User toAdd);

    void update(User toUpdate);

    void delete(Long id);

    List<User> getAll();
}
