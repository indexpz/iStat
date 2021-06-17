package pl.indexpz.iStat.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.repository.VehicleRecordRepository;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Slf4j
public class JpaVehicleRecordService implements VehicleRecordService {

    private final VehicleRecordRepository vehicleRecordRepository;

    public JpaVehicleRecordService(VehicleRecordRepository vehicleRecordRepository) {
        this.vehicleRecordRepository = vehicleRecordRepository;
    }

    @Override
    public VehicleRecord getById(Long id) {
        return (VehicleRecord) vehicleRecordRepository.findAllById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("VehicleRecord with id: %d not exist", id)));
    }

    @Override
    public VehicleRecord add(VehicleRecord toAdd) {
        log.info("Saving vehicleRecord " + toAdd);
        return vehicleRecordRepository.save(toAdd);
    }

    @Override
    public void update(VehicleRecord toUpdate) {
        log.info("Updating vehicle " + toUpdate);
        VehicleRecord vehicleRecord = getById(toUpdate.getId());
        vehicleRecord.setDate(toUpdate.getDate());
        vehicleRecord.setMeter(toUpdate.getMeter());
        vehicleRecord.setQuantity(toUpdate.getQuantity());
        vehicleRecord.setPrice(toUpdate.getPrice());
        vehicleRecordRepository.save(vehicleRecord);
    }

    @Override
    public void delete(Long id) {
        VehicleRecord vehicleRecord = getById(id);
        log.info("Delete vehicleRecord: " + vehicleRecord);
        vehicleRecordRepository.delete(vehicleRecord);
    }

    @Override
    public List<VehicleRecord> getAll() {
        return vehicleRecordRepository.findAll();
    }
}
