package umc.spring.study.apiPayload.code;

public interface BaseErrorCode extends ErrorReason {

    ErrorReason getReason();

    ErrorReason getReasonHttpStatus();



}
