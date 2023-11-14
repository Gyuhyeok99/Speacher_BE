package gdsc.speacher.feedback.dto;

import gdsc.speacher.domain.Video;
import gdsc.speacher.domain.feedback.CV;
import gdsc.speacher.domain.feedback.NLP;
import gdsc.speacher.domain.feedback.VR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {
    private VideoDto videoDto;
    private CvDto cvDto;
    private NlpDto nlpDto;
    private VrDto vrDto;

    private String title;

    public FeedbackDto(Video video, CV cv, NLP nlp, VR vr, String title) {
        this.videoDto = new VideoDto(video);
        this.cvDto = new CvDto(cv.getVal());
        this.nlpDto = new NlpDto(nlp.getVal());
        this.vrDto = new VrDto(vr.getVal());
        this.title = title;
    }
}
