package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
