package pl.indexpz.iStat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.Code;

import javax.persistence.*;

@Entity
@Table(name="users_details")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column
    private String street;
    @Column(name="street_number")
    private String streetNumber;
    @Column(name="apartment_number")
    private String apartmentNumber;
    @Column(name="postal_code")
    private String postalCode;
    @Column
    private String city;

}
