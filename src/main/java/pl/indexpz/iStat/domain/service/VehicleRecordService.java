package pl.indexpz.iStat.domain.service;

import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.List;

public interface VehicleRecordService {

    VehicleRecord getById(Long id);

    VehicleRecord add(VehicleRecord toAdd);

    void update(VehicleRecord toUpdate);

    void delete(Long id);

    List<VehicleRecord> getAll();
}
