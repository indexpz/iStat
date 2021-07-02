package pl.indexpz.iStat.domain.service;

import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.List;

public interface VehicleRecordService {

    public VehicleRecord addVehicleRecord(VehicleRecord vehicleRecordToAdd);

    public List<VehicleRecord> getVehicleRecords();

    public VehicleRecord getVehicleRecordById(Long vehicleRecordId);

    public void updateVehicleRecord(VehicleRecord vehicleRecordToUpdate);

    public void removeVehicleRecord(VehicleRecord vehicleRecordToDelete);


}
