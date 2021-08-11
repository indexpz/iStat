package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    List<Vehicle> findAllByUserUsername(String username);

    Vehicle findVehicleByVehicleName(String vehicleName);

}
