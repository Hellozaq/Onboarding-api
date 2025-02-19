package suai.vladislav.onboardingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suai.vladislav.onboardingapi.models.Scoreboard;

@Repository
public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {
}
