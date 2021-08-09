package pl.indexpz.iStat.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.MeterRecord;

import java.util.List;

@Service
@Repository
@Transactional
public interface MeterService {

    MeterRecord addMeter(MeterRecord meter);

    List<MeterRecord> getMeters();

    MeterRecord getMeterById(Long id);

    MeterRecord getMeterByMeterName(String meterName);

    void updateMeter(MeterRecord meter);

    void removeMeter(MeterRecord meter);
}
