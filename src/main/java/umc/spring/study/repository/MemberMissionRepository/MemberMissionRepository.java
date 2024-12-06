package umc.spring.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;

import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission,Long>, MemberMissionRepositoryCustom {
    boolean existsByMissionId(Long missionId);

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

    // 내가 진행중인 미션 목록 확인하기
    List<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status);

}
