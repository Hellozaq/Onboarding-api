package suai.vladislav.onboardingapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JsonManagedReference("module-track")
    @OneToMany(mappedBy = "track", fetch = FetchType.EAGER)
    private List<Module> modules;
}
