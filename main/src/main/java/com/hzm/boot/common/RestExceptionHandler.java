package com.hzm.boot.common;

import com.hzm.boot.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 运行时异常
     * @param e
     * @param <T>
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    private <T> RestResult<T> runtimeExceptionHandler(Exception e){
        LOGGER.error("------->error !" ,e);
        return new RestResultBuilder<T>()
                .setErrorCode(ErrorCode.ERROR.getCode())
                .setMessage(ErrorCode.ERROR.getMsg())
                .build();
    }

    /**
     * 参数校验非法
     * @param e
     * @param <T>
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    private <T> RestResult<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
        LOGGER.error("---------> invalid request!", e);
        return new RestResultBuilder<T>()
                .setErrorCode(ErrorCode.ERROR_METHOD.getCode())
                .setMessage(ErrorCode.ERROR_METHOD.getMsg())
                .build();
    }

    /**
     * 请求参数非法
     * @param e
     * @param <T>
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    private <T> RestResult<T> illegalParamsExceptionHandler(MissingServletRequestParameterException e) {
        LOGGER.error("---------> invalid param!", e);
        return new RestResultBuilder<T>()
                .setErrorCode(ErrorCode.ERROR_METHOD.getCode())
                .setMessage(ErrorCode.ERROR_METHOD.getMsg())
                .build();
    }

    /**
     * 业务异常
     * @param e
     * @param <T>
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    private <T> RestResult<T> exceptionHandler(BaseException e){
        LOGGER.error("---------> business exception!", e);
        return new RestResultBuilder<T>()
                .setErrorCode(e.getErrorCode())
                .setMessage(e.getMessage())
                .build();
    }

}