package umc.spring.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return convertToDTO(this.code.getReason());
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return convertToDTO(this.code.getReasonHttpStatus());
    }

    // Helper 메서드: ErrorReason을 ErrorReasonDTO로 변환
    private ErrorReasonDTO convertToDTO(umc.spring.study.apiPayload.code.ErrorReason reason) {
        return ErrorReasonDTO.builder()
                .httpStatus(reason.getHttpStatus())
                .code(reason.getCode())
                .message(reason.getMessage())
                .isSuccess(reason.getIsSuccess())
                .build();
    }

}
