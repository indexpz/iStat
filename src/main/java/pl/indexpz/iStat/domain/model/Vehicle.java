package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
    @Column(name = "meter")
    private String meter;
    @Column(name = "fuel_efficiency")
    private String fuelEfficiency;
    @Column(name = "cost_per_distance")
    private String costPerDistance;


    @OneToMany(mappedBy = "id")
    private List<VehicleRecord> vehicleRecords = new ArrayList<>();

    @ManyToOne
    private User user;
}
