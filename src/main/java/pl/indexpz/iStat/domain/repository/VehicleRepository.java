package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
