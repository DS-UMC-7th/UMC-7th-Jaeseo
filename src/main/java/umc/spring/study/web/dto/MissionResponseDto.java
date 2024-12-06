package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import umc.spring.study.domain.Mission;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class MissionResponseDto {
    private Long missionId;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;

    public static MissionResponseDto fromEntity(Mission mission) {
        return MissionResponseDto.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
