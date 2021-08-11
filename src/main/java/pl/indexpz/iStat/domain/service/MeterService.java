package pl.indexpz.iStat.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.Meter;
import pl.indexpz.iStat.domain.model.MeterRecord;

import java.util.List;
import java.util.Optional;

@Service
@Repository
@Transactional
public interface MeterService {

    Meter addMeter(Meter meter);

    List<Meter> getMeters();

    Optional<Meter> getMeterById(Long id);

    Meter getMeterByMeterName(String meterName);

    void updateMeter(Meter meter);

    void removeMeter(Meter meter);
}
