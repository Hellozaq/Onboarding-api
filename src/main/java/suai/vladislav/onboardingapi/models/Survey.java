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
@Table(name = "Survey")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Survey extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    @JoinTable(
        name = "SurveyXUser",
        joinColumns = @JoinColumn(name = "surveyId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> users;
}
