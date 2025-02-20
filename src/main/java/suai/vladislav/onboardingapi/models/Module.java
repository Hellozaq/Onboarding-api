package suai.vladislav.onboardingapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Module extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String startContent;

    @Column(nullable = false, columnDefinition = "TEXT")
    private Integer endContent;

    @Column(nullable = false, unique = true)
    private Integer orderInTrack;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "module-track")
    @JoinColumn(name = "trackId")
    private Track track;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    private List<Page> pages;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    private List<UserProgressInModule> userProgressInModules;
}
