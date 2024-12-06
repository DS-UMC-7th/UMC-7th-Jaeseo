package umc.spring.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.web.dto.MemberMissionResponseDto;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    // 내가 진행중인 미션 조회하기
    public List<MemberMissionResponseDto> getInProgressMissions(Long memberId) {
        List<MemberMission> memberMissions = memberMissionRepository.findByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING);

        return memberMissions.stream()
                .map(memberMission -> MemberMissionResponseDto.builder()
                        .missionId(memberMission.getMission().getId())
                        .missionSpec(memberMission.getMission().getMissionSpec())
                        .status(memberMission.getStatus())
                        .deadline(memberMission.getMission().getDeadline().toString())
                        .build())
                .collect(Collectors.toList());
    }
}
