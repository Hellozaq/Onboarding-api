package suai.vladislav.onboardingapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "Track")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Track extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer modulesCount;

    @OneToMany(mappedBy = "track", fetch = FetchType.LAZY)
    private List<Module> modules;
}
