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
@Table(name = "Page")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page extends BaseEntity {
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer orderInModule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moduleId")
    private Module module;
}
