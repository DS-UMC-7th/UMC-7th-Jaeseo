package umc.spring.study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Region;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,Long> {
    Optional<Region> findByName(String name); //지역 이름으로 조회

}
