package umc.spring.study.web.dto;

import lombok.Getter;
import umc.spring.study.validation.annotation.ExistCategories;

import java.util.List;
@Getter
public class JoinDto {
    String name;
    Integer gender;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    String address;
    String specAddress;

    @ExistCategories
    List<Long> preferCategory;
}