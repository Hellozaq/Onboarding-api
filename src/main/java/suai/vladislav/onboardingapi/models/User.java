package suai.vladislav.onboardingapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import suai.vladislav.onboardingapi.enums.Role;

import java.util.List;

@Entity
@Table(name = "_User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractEntity{
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Scoreboard> scoreboards;

    @OneToMany(mappedBy = "user")
    private List<UserProgressInModule> userProgressInModules;

    @ManyToMany(mappedBy = "users")
    private List<Survey> surveys;

    @ManyToMany(mappedBy = "users")
    private List<Achievement> achievements;
}
