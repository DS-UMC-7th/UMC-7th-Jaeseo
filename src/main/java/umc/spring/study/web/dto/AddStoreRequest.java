package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddStoreRequest {

    private String regionName; //지역 이름
    private String storeName; // 가게 이름
    private String storeAddress; // 가게 주소
    private Float score; // 가게 점수
}
