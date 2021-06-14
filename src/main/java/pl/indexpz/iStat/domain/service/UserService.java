package pl.indexpz.iStat.domain.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Service
@Repository
@Transactional
public class UserService {

    @PersistenceContext
    protected EntityManager em;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User entity){
        return userRepository.save(entity);
    }

    public User update(User entity){
        return em.merge(entity);
    }

    public void remove(User entity){
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return em.find(User.class, id);
    }
}
