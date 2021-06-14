package pl.indexpz.iStat.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.executable.ValidateOnExecution;

@Entity
@Table(name="records")
@Getter
@Setter
@ToString(exclude = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double meter;
    @Column
    private Double price;


    @ManyToOne
    private Vehicle vehicle;
}
