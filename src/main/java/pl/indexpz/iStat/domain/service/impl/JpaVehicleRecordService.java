package pl.indexpz.iStat.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.repository.VehicleRecordRepository;
import pl.indexpz.iStat.domain.repository.VehicleRepository;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.domain.service.VehicleService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class JpaVehicleRecordService implements VehicleRecordService {

    private final VehicleRecordRepository vehicleRecordRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;


    @Override
    @Transactional
    public VehicleRecord addVehicleRecord(VehicleRecord vehicleRecordToAdd) {

//        Vehicle vehicle = vehicleRepository.findById().orElseThrow((() -> new ResourceNotFoundException("Vehicle with id " + vehicleId + " not exist.")));
//
        vehicleRecordToAdd.setVehicle(vehicleRecordToAdd.getVehicle());
        return vehicleRecordRepository.save(vehicleRecordToAdd);
    }


    @Override
    public List<VehicleRecord> getVehicleRecords() {
        return vehicleRecordRepository.findAll();
    }

    @Override
    public VehicleRecord getVehicleRecordById(Long vehicleRecordId) {
        return vehicleRecordRepository.findById(vehicleRecordId).orElseThrow(() -> new ResourceNotFoundException("Record with id " + vehicleRecordId + " not exist."));
    }

    @Override
    public void updateVehicleRecord(VehicleRecord vehicleRecordToUpdate) {
        VehicleRecord vehicleRecord = getVehicleRecordById(vehicleRecordToUpdate.getId());
        vehicleRecord.setData(vehicleRecordToUpdate.getData());
        vehicleRecord.setDistanceMeter(vehicleRecordToUpdate.getDistanceMeter());
        vehicleRecord.setRefueling(vehicleRecordToUpdate.getRefueling());
        vehicleRecord.setPricePerFuelUnit(vehicleRecordToUpdate.getPricePerFuelUnit());
        vehicleRecordRepository.save(vehicleRecord);

    }

    @Override
    public void removeVehicleRecord(VehicleRecord vehicleRecordToDelete) {
        VehicleRecord vehicleRecord = getVehicleRecordById(vehicleRecordToDelete.getId());
        vehicleRecordRepository.delete(vehicleRecord);
    }



}
