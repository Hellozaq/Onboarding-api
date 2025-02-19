package suai.vladislav.onboardingapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Module")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Module extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer pagesCount;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String startContent;

    @Column(nullable = false, columnDefinition = "TEXT")
    private Integer endContent;

    @Column(nullable = false, unique = true)
    private Integer orderInTrack;

    @ManyToOne
    @JoinColumn(name = "trackId")
    private Track track;

    @OneToMany(mappedBy = "module")
    private List<Page> pages;

    @OneToMany(mappedBy = "module")
    private List<UserProgressInModule> userProgressInModules;
}
