package pl.indexpz.iStat.domain.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.repository.VehicleRepository;
import pl.indexpz.iStat.domain.service.VehicleService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Slf4j
public class JpaVehicleService implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public JpaVehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle getById(Long id) {
        return (Vehicle) vehicleRepository.findAllById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Vehicle with id: %d not exist", id)));
    }

    @Override
    public Vehicle add(Vehicle toAdd) {
        log.info("Saving vehicle " + toAdd);
        return vehicleRepository.save(toAdd);
    }

    @Override
    public void update(Vehicle toUpdate) {
        log.info("Updating vehicle " + toUpdate);
        Vehicle vehicle = getById(toUpdate.getId());
        vehicle.setName(toUpdate.getName());
        vehicle.setCurrency(toUpdate.getCurrency());
        vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = getById(id);
        log.info("Delete vehicle: " + vehicle);
        vehicleRepository.delete(vehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
