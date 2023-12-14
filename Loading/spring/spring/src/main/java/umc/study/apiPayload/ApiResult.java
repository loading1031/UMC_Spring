package umc.study.apiPayload;

import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.status.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess","code","message","result"})
public class ApiResult<T> {
    @JsonProperty("isSucess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 실패한 경우 응답 생성
    public static <T> ApiResult<T> onFailure(String code, String message, T data){
        return new ApiResult<>(true, code, message, data);
    }

    //성공한 경우 응답 생성
    public static <T> ApiResult<T> onSuccess(T result){
        return new ApiResult<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

     public static <T> ApiResult<T> of(BaseCode code, T result){
        return new ApiResult<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }

}
