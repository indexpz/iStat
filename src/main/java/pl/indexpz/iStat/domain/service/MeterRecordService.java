package pl.indexpz.iStat.domain.service;

import pl.indexpz.iStat.domain.model.Meter;
import pl.indexpz.iStat.domain.model.MeterRecord;

import java.util.List;
import java.util.Optional;

public interface MeterRecordService {

    MeterRecord addMeterRecord(MeterRecord meterRecord, Meter meter);

    List<MeterRecord> getMeterRecordsByMeterId(Long id);

    Optional<MeterRecord> getMeterRecordById(Long id);

    void updateMeterRecord(MeterRecord meterRecord);

    void deleteMeterRecord(MeterRecord meterRecord);

}
