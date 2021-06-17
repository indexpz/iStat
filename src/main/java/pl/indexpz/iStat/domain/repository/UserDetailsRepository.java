package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    Optional<Object> findAllById(Long id);
}
