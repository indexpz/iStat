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

    public Vehicle addVehicle(Vehicle vehicleToAdd);

    public List<Vehicle> getVehicles();

     public Vehicle getVehicleById(Long vehicleId);


     public void updateVehicle(Vehicle vehicleToUpdate);

     public void removeVehicle(Vehicle vehicleToDelete);
}
