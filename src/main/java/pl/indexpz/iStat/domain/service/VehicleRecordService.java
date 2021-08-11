package pl.indexpz.iStat.domain.service;

import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.List;
import java.util.Optional;

public interface VehicleRecordService {


    VehicleRecord addVehicleRecord(VehicleRecord vehicleRecordToAdd, Vehicle vehicle);

    List<VehicleRecord> getVehicleRecordsByVehicleId(Long vehicleId);

    Optional<VehicleRecord> getVehicleRecordById(Long vehicleRecordId);

    void updateVehicleRecord(VehicleRecord vehicleRecordToUpdate);

    void removeVehicleRecord(VehicleRecord vehicleRecordToDelete);

}
