package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.MeterRecord;

import java.util.List;

public interface MeterRecordRepository extends JpaRepository<MeterRecord, Long> {

    List<MeterRecord> findAllByMeter(String meterName);
}
