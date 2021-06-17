package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.Optional;

public interface VehicleRecordRepository extends JpaRepository<VehicleRecord, Long> {
    Optional<Object> findAllById(Long id);
}
