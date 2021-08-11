package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vehicle_name")
    private String vehicleName;
    @Column(name = "meter_unit")
    private String meterUnit;
    @Column(name = "fuel_name")
    private String fuelName;
    @Column(name = "fuel_unit")
    private String fuelUnit;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleRecord> vehicleRecords = new ArrayList<>();

    @ManyToOne
    private User user;
}
