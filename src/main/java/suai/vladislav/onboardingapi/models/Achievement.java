package suai.vladislav.onboardingapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Achievement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievement extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String picture;

    @ManyToMany
    @JoinTable(
        name = "AchievementXUser",
        joinColumns = @JoinColumn(name = "AchievementId"),
        inverseJoinColumns = @JoinColumn(name = "UserId")
    )
    private List<User> users;
}
