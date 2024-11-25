package umc.spring.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.mapping.MemberMission;
@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission,Long>, MemberMissionRepositoryCustom {
    boolean existsByMissionId(Long missionId);

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

}
