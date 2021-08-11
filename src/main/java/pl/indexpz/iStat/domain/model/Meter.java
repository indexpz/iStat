package pl.indexpz.iStat.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column
    private String unit;
    @Column
    private String description;

    @OneToMany(mappedBy = "meter", cascade = CascadeType.ALL)
    private List<MeterRecord> meterRecords = new ArrayList<>();

    @ManyToOne
    private User user;
}
