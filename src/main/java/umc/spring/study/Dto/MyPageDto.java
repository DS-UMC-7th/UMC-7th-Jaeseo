package umc.spring.study.Dto;

public class MyPageDto {

    private String name;
    private String email;
    private String phoneNumber;
    private Integer currentPoints;

    public MyPageDto(String name, String email, String phoneNumber, Integer currentPoints) {
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.currentPoints=currentPoints;
    }


}
