package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MissionChallengeRequest {

    @NotNull(message = "Member ID is required")
    private Long memberId;

    @NotNull(message = "Mission ID is required")
    private Long missionId;

    private Integer reward; // Optional, if needed for additional operations
    private LocalDate deadline; // Optional, if needed for additional operations
    private String missionSpec; // Optional, if needed for additional operations
}
