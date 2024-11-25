package umc.spring.study.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Food_category;

public interface FoodCategoryRepository extends JpaRepository<Food_category, Long> {

}
