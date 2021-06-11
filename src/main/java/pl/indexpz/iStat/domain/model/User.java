package pl.indexpz.iStat.domain.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name="users")
@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude={"password"} )
@Builder


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private UserDetails details = new UserDetails();
}
