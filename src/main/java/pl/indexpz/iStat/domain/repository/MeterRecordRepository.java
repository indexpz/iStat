package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.Meter;
import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.List;

public interface MeterRecordRepository extends JpaRepository<MeterRepository, Long> {

    List<VehicleRecord> findAllMeterRecordsByMeter(Meter meter);
}
