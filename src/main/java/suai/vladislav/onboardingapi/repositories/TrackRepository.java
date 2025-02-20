package suai.vladislav.onboardingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suai.vladislav.onboardingapi.models.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
