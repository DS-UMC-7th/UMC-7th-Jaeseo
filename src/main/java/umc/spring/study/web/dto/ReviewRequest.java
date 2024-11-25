package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.study.validation.annotation.StoreExists;

@Getter
@Setter
public class ReviewRequest {

    @NotNull(message = "Store ID is required")
    @StoreExists
    private Long storeId;

    @NotNull(message = "Member ID is required")
    private Long memberId;

    @NotNull(message = "Review body is required")
    private String body;

    @NotNull(message = "Score is required")
    private Float score;
}
