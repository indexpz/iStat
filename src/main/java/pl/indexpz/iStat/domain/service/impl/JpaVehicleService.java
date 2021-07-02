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
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class JpaVehicleService implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;


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
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Vehicle with id " + id + " not exist.")));
    }


    @Override
    public void updateVehicle(Vehicle vehicleToUpdate) {
        Vehicle vehicle = getVehicleById(vehicleToUpdate.getId());
        vehicle.setVehicleName(vehicleToUpdate.getVehicleName());
        vehicle.setFuelName(vehicleToUpdate.getFuelName());
        vehicle.setFuelUnit(vehicle.getFuelUnit());
        vehicle.setMeterUnit(vehicleToUpdate.getMeterUnit());
        vehicleRepository.save(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicleToDelete) {
        Vehicle vehicle = getVehicleById(vehicleToDelete.getId());
        vehicleRepository.delete(vehicle);
    }
}
