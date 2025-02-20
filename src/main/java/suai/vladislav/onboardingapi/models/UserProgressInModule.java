package suai.vladislav.onboardingapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class UserProgressInModule extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer lastCompletedPageNumber;

    @Column(nullable = false)
    private Integer pagesCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moduleId")
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
}
