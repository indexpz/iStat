package pl.indexpz.iStat.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude={"password",  "vehicles"} )
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nickName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

  @OneToMany(mappedBy = "name")
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToOne(optional = false,  cascade = CascadeType.ALL)
    private UserDetails details = new UserDetails();
}
