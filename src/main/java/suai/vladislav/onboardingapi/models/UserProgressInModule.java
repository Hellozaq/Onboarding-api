package suai.vladislav.onboardingapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserProgressInModule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProgressInModule extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer lastCompletedPageNumber;

    @Column(nullable = false)
    private Integer pagesCount;

    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
