package pl.indexpz.iStat.domain.service;


import pl.indexpz.iStat.domain.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getById(Long id);

    Vehicle add(Vehicle toAdd);

    void update(Vehicle toUpdate);

    void delete(Long id);

    List<Vehicle> getAll();
}
