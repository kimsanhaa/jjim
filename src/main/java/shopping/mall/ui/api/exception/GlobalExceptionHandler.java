package shopping.mall.ui.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shopping.mall.ui.api.response.ErrorResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> businessExceptionHandler(BusinessException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getCode());
        return new ResponseEntity<>(errorResponse,HttpStatus.OK);
    }
}
