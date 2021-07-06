package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    @Column(name = "meter_unit")
    private String meterUnit;
    @Column(name = "fuel_name")
    private String fuelName;
    @Column(name = "fuel_unit")
    private String fuelUnit;


//    @OneToMany( cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
//    @JoinColumn(name = "vehicle_id")
    private List<VehicleRecord> vehicleRecords = new ArrayList<>();

    @ManyToOne
    private User user;
}
