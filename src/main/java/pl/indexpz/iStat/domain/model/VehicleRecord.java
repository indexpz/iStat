package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


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
    @Column(name="price_per_fuel_unit", scale = 2, precision = 7)
    private Double pricePerFuelUnit;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String data;

    @ManyToOne
    private Vehicle vehicle;

}
