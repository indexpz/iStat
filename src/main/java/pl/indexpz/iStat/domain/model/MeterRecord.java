package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "meter_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeterRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data;
    @Column(name = "meter_record", scale = 2, precision = 7)
    private Double meterRecord;
    @Column(columnDefinition = "boolean default false")
    private Boolean status;
    @Column
    private String description;


}
