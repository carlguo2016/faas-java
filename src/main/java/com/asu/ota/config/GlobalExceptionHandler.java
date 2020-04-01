package com.asu.ota.config;

import com.asu.tool.common.result.CodeMsg;
import com.asu.tool.common.result.Result;
import com.asu.tool.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: carl
 * @Date: 2020-01-16 14:47
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = Exception.class)
    public Result<Object> handleBadRequest(Exception e) {
        /*
         * 参数校验异常
         */
        if (e instanceof BindException) {
            BindingResult bindingResult = ((BindException) e).getBindingResult();
            if (bindingResult.hasErrors()) {
                FieldError error = bindingResult.getFieldErrors().get(0);
                String msg = error.getDefaultMessage();
                return Result.error(new CodeMsg(GlobalException.ERROR_WRONG_PARAM, msg));
            }
        }

        /*
         * 业务逻辑异常
         */
        if (e instanceof GlobalException) {
            return Result.error(((GlobalException) e).getCm());
        }

        /*
         * 其他未知异常
         */
        log.error("Error: handleBadRequest StackTrace : {}", e);
        return Result.error(new CodeMsg(GlobalException.ERROR_SERVER, e.getMessage()));
    }

}
