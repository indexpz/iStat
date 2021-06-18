package pl.indexpz.iStat.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@ToString(exclude = "user")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String meterUnit;
    @Column(nullable = false)
    private String unit;
    @Column(nullable = false)
    private String currency;


    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "id")
    private List<VehicleRecord> vehicleRecords = new ArrayList<>();
}
