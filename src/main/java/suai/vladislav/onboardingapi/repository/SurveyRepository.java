package suai.vladislav.onboardingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suai.vladislav.onboardingapi.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
