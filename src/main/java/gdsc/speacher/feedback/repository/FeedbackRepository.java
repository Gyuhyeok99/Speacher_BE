package gdsc.speacher.feedback.repository;

import gdsc.speacher.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<List<Feedback>> findAllByVideoIdOrderByCreateDateDesc(Long id);
}
