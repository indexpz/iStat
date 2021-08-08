package pl.indexpz.iStat.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.Vehicle;

import java.util.List;

@Service
@Repository
@Transactional
public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicleToAdd);

    List<Vehicle> getVehicles();

    Vehicle getVehicleById(Long vehicleId);

    Vehicle getVehicleByVehicleName(String vehicleName);

    void updateVehicle(Vehicle vehicleToUpdate);

    void removeVehicle(Vehicle vehicleToDelete);
}
