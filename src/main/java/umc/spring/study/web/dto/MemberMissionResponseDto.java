package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import umc.spring.study.domain.enums.MissionStatus;
@Getter
@Builder
@AllArgsConstructor
public class MemberMissionResponseDto {
    private Long missionId;
    private String missionSpec;
    private MissionStatus status;
    private String deadline;
}
