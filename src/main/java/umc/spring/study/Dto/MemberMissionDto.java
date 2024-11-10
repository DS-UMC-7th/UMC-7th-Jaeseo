package umc.spring.study.Dto;

import java.time.LocalDateTime;

public class MemberMissionDto {

    private Long memberMissionId;
    private Long missionId;
    private String status;
    private Integer reward;
    private LocalDateTime deadline;
    private LocalDateTime missionStartDate;
    private String storeName;
    private String regionName;

    public MemberMissionDto(Long memberMissionId, Long missionId, String status, Integer reward,
                            LocalDateTime deadline, LocalDateTime missionStartDate,
                            String storeName, String regionName) {
        this.memberMissionId = memberMissionId;
        this.missionId = missionId;
        this.status = status;
        this.reward = reward;
        this.deadline = deadline;
        this.missionStartDate = missionStartDate;
        this.storeName = storeName;
        this.regionName = regionName;
    }

}
