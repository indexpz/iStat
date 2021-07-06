package pl.indexpz.iStat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;

import java.util.List;
import java.util.Optional;

public interface VehicleRecordRepository extends JpaRepository<VehicleRecord, Long> {

    List<VehicleRecord> findAllVehicleRecordByVehicle(Vehicle vehicle);


}
