package gdsc.speacher.controller;

import gdsc.speacher.entity.Feedback;
import gdsc.speacher.exception.FeedbackException;
import gdsc.speacher.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static gdsc.speacher.exception.ErrorCode.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feedbacks")
@Slf4j
@CrossOrigin
public class FeedbackController {

    private final FeedbackService feedbackService;

    // 특정 피드백 조회
    @GetMapping("/{videoId}/{feedbackId}")
    public ResponseEntity findFeedbackByFeedbackId(@PathVariable Long videoId, @PathVariable Long feedbackId) {
        Optional<Feedback> byFeedbackId = feedbackService.findByFeedbackId(feedbackId);
        if (byFeedbackId.isEmpty()) {
            throw new FeedbackException(INVALID_FEEDBACK_ID);
        }
        return ResponseEntity.ok().body(byFeedbackId.get());
    }

    // 특정 비디오 피드백 모두 조회
    @GetMapping("/{videoId}")
    public ResponseEntity findFeedbacksByVideoId(@PathVariable Long videoId) {
        Optional<List<Feedback>> byVideoId = feedbackService.findByVideoId(videoId);
        if (byVideoId.isEmpty()) {
            throw new FeedbackException(INVALID_VIDEO_ID);
        }
        return ResponseEntity.ok().body(byVideoId.get());
    }
}
