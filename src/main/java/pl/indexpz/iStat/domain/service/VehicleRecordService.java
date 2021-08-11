package pl.indexpz.iStat.domain.service;

import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.List;
import java.util.Optional;

public interface VehicleRecordService {


    VehicleRecord addVehicleRecord(VehicleRecord vehicleRecord, Vehicle vehicle);

    List<VehicleRecord> getVehicleRecordsByVehicleId(Long id);

    Optional<VehicleRecord> getVehicleRecordById(Long id);

    void updateVehicleRecord(VehicleRecord vehicleRecord);

    void removeVehicleRecord(VehicleRecord vehicleRecord);

}
