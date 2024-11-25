package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.service.ReviewService.ReviewService;
import umc.spring.study.web.dto.ReviewRequest;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 작성 API
    @PostMapping
    public ResponseEntity<?> addReview(@Valid @RequestBody ReviewRequest reviewRequest) {
        reviewService.addReview(reviewRequest);
        return ResponseEntity.ok("Review added successfully");
    }
}
