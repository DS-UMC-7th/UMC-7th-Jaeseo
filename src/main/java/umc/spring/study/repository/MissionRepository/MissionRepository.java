package umc.spring.study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Mission;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

    List<Mission> findByStore_Id(Long storeId); // Store의 id로 미션 목록을 가져옴.

}
