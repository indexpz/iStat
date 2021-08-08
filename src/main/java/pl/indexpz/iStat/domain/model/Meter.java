package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "meter_name")
    private String meterName;
    @Column(name = "meter_reading")
    private Double meterReading;
    @Column
    private String unit;
    @Column(columnDefinition = "boolean default false")
    private Boolean status;
    @Column
    private String description;
}
