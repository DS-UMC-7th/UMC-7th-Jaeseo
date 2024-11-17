package umc.spring.study.apiPayload.code;

import org.springframework.http.HttpStatus;

public interface ErrorReason {
    String getCode();
    String getMessage();
    boolean getIsSuccess();
    HttpStatus getHttpStatus();

}
