package umc.spring.study.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // result가 null일 경우 제외
public class ResponseDto<T> {

    private final Boolean isSuccess;
    private final String message;
    private final T result;

    // 성공 응답 생성
    public static <T> ResponseDto<T> onSuccess(T result, String code) {
        return new ResponseDto<>(true, code, result);
    }

    // 실패 응답 생성
    public static <T> ResponseDto<T> onFailure(String message, String code) {
        return new ResponseDto<>(false, code, null);
    }

}
