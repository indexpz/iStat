package pl.indexpz.iStat.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.executable.ValidateOnExecution;

@Entity
@Table(name="vehicle_records")
@Getter
@Setter
@ToString(exclude = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRecord extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String date;
    @Column
    private Double meter;
    @Column
    private Double quantity;
    @Column
    private Double price;


    @ManyToOne
    private Vehicle vehicle;
}
