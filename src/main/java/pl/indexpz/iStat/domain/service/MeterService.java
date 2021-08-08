package pl.indexpz.iStat.domain.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.Meter;

import java.util.List;

@Service
@Repository
@Transactional
public interface MeterService {

    Meter addMeter(Meter meter);

    List<Meter> getMeters();

    Meter getMeterById(Long id);

    Meter getMeterByMeterName(String meterName);

    void updateMeter(Meter meter);

    void removeMeter(Meter meter);
}
