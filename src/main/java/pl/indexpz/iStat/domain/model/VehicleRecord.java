package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
//    @NotBlank
//    @DateTimeFormat
    private Integer distanceMeter;
    @Column
//    @NotBlank
//    @NumberFormat
    private Double refueling;
    @Column(name="price_per_fuel_unit")
//    @NotBlank
//    @NumberFormat
    private Double pricePerFuelUnit;
    @Column
//    @NotBlank
//    @NumberFormat
    private String data;


    @ManyToOne
    private Vehicle vehicle;

}
