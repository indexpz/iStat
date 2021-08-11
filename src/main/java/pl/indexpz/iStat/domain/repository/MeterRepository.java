package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.Meter;
import pl.indexpz.iStat.domain.model.MeterRecord;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Long> {
    List<Meter> findAllByUserUsername(String username);

    Meter findMeterByMeterName(String meterName);
}
