package umc.spring.study.converter;

import umc.spring.study.domain.Food_category;
import umc.spring.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    // 양방향 연관 관계 설정은 converter보다는 service에서 하는 것이 좋음

    public static List<MemberPrefer> toMemberPreferList(List<Food_category> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}

