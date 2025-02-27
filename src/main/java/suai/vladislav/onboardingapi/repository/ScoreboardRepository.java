package suai.vladislav.onboardingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suai.vladislav.onboardingapi.model.Scoreboard;

@Repository
public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {
}
