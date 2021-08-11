package pl.indexpz.iStat.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.repository.VehicleRecordRepository;
import pl.indexpz.iStat.domain.repository.VehicleRepository;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class VehicleRecordServiceImpl implements VehicleRecordService {

    private final VehicleRecordRepository vehicleRecordRepository;
    private final VehicleRepository vehicleRepository;


//    @Override
//    public VehicleRecord addVehicleRecord(VehicleRecord vehicleRecordToAdd) {
//        Vehicle vehicle = vehicleRepository.findVehicleByVehicleRecord(vehicleRecordToAdd);
//        vehicleRecordToAdd.setVehicle(vehicle);
//        return vehicleRecordRepository.save(vehicleRecordToAdd);
//    }

    @Override
    @Transactional
    public VehicleRecord addVehicleRecord(VehicleRecord vehicleRecordToAdd, Vehicle vehicle) {
        vehicleRecordToAdd.setVehicle(vehicle);
        return vehicleRecordRepository.save(vehicleRecordToAdd);
    }

    @Override
    public List<VehicleRecord> getVehicleRecordsByVehicleId(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + vehicleId + " not exist."));
        return vehicleRecordRepository.findAllVehicleRecordByVehicle(vehicle);
    }

    @Override
    public Optional<VehicleRecord> getVehicleRecordById(Long vehicleRecordId) {
        return vehicleRecordRepository.findById(vehicleRecordId);
    }

    @Override
    public void updateVehicleRecord(VehicleRecord vehicleRecordToUpdate) {
        Optional<VehicleRecord> optionalVehicleRecord = getVehicleRecordById(vehicleRecordToUpdate.getId());
        if (optionalVehicleRecord.isPresent()) {
            VehicleRecord vehicleRecord = optionalVehicleRecord.get();
            vehicleRecord.setData(vehicleRecordToUpdate.getData());
            vehicleRecord.setDistanceMeter(vehicleRecordToUpdate.getDistanceMeter());
            vehicleRecord.setRefueling(vehicleRecordToUpdate.getRefueling());
            vehicleRecord.setPricePerFuelUnit(vehicleRecordToUpdate.getPricePerFuelUnit());
            vehicleRecordRepository.save(vehicleRecord);
        } else {
            VehicleRecord vehicleRecord = new VehicleRecord();
        }

    }

    @Override
    public void removeVehicleRecord(VehicleRecord vehicleRecordToDelete) {
        Optional<VehicleRecord> optionalVehicleRecord = getVehicleRecordById(vehicleRecordToDelete.getId());
        if (optionalVehicleRecord.isPresent()) {
            VehicleRecord vehicleRecord = optionalVehicleRecord.get();
            vehicleRecordRepository.delete(vehicleRecord);
        } else {
            VehicleRecord vehicleRecord = new VehicleRecord();
        }
    }
}
