package umc.spring.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO implements ErrorReason {

    private HttpStatus httpStatus;
    private final boolean isSuccess;
    private final String code;
    private final String message;
    @Override
    public boolean getIsSuccess() {return isSuccess;}

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
