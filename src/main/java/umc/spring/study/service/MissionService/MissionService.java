package umc.spring.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.repository.MemberRepository.MemberRepository;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.web.dto.MissionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public void challengeMission(Long memberId, Long missionId) {
        // Check if Member exists
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member does not exist"));

        // Check if Mission exists
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission does not exist"));

        // Check if Member is already challenging the Mission
        boolean isAlreadyChallenging = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
        if (isAlreadyChallenging) {
            throw new IllegalArgumentException("Member is already challenging this Mission.");
        }

        // Add the Mission to Member's challenges
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
        memberMissionRepository.save(memberMission);
    }

    // 특정 가게의 미션 목록 조회하기
    public List<MissionResponseDto> getMissionsByStore(Long storeId) {
        List<Mission> missions = missionRepository.findByStore_Id(storeId);
        return missions.stream()
                .map(MissionResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
