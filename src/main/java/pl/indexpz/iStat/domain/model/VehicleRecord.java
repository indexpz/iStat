package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="distance_meter")
    private Integer distanceMeter;
    @Column
    private Double refueling;
    @Column(name="price_per_fuel_unit")
    private Double pricePerFuelUnit;
    @Column
    private LocalDate data;


    @ManyToOne
    private Vehicle vehicle;

}
