package pl.indexpz.iStat.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.repository.VehicleRepository;
import pl.indexpz.iStat.domain.service.VehicleService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class VehicleServiceImpl implements VehicleService {

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public Vehicle addVehicle(Vehicle vehicleToAdd) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).get();
        vehicleToAdd.setUser(user);
        return vehicleRepository.save(vehicleToAdd);
    }

    @Override
    public List<Vehicle> getVehicles() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return vehicleRepository.findAllByUserUsername(username);
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    @Override
    public Vehicle getVehicleByVehicleName(String vehicleName) {
        Vehicle vehicle = vehicleRepository.findVehicleByVehicleName(vehicleName);
        return vehicle;
    }

    @Override
    public void updateVehicle(Vehicle vehicleToUpdate) {
        Optional<Vehicle>  optionalVehicle = getVehicleById(vehicleToUpdate.getId());
        if(optionalVehicle.isPresent()){
            Vehicle vehicle = optionalVehicle.get();
            vehicle.setVehicleName(vehicleToUpdate.getVehicleName());
            vehicle.setFuelName(vehicleToUpdate.getFuelName());
            vehicle.setFuelUnit(vehicle.getFuelUnit());
            vehicle.setMeterUnit(vehicleToUpdate.getMeterUnit());
            vehicleRepository.save(vehicle);
        }else{
            Vehicle vehicle = new Vehicle();
        }
    }

    @Override
    public void removeVehicle(Vehicle vehicleToDelete) {
        Optional<Vehicle>  optionalVehicle = getVehicleById(vehicleToDelete.getId());
        if(optionalVehicle.isPresent()){
            Vehicle vehicle = optionalVehicle.get();
            vehicleRepository.delete(vehicle);
        }else{
            Vehicle vehicle = new Vehicle();
        }

    }
}
