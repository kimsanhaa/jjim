package shopping.mall.ui.api.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private int code;
    private String message;

    public BusinessException(ExceptionResponse er) {
        this.code = er.getCode();
        this.message = er.getMessage();
    }
}
