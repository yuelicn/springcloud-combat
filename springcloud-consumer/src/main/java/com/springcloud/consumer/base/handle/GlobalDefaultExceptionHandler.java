package com.springcloud.consumer.base.handle;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.springcloud.common.exception.BizException;
import com.springcloud.common.response.ResponseData;
import com.springcloud.consumer.base.enums.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * 统一异常处理
 * 1、BizExceptionHandler# 业务异常处理
 * 2、nullPointerExceptionHandler# 空指针异常处理
 * 3、constraintViolationExceptionHandler# 注解参数校验异常
 * 4、missingServletRequestParameterExceptionHandler# Required = true 参数校验
 * 5、HttpClientErrorException# http请求异常
 * 6、IllegalStateException# No instances available for serverName
 * 7、InvalidFormatException# Cannot deserialize value of type `java.util.Date` from String "2019-12-03": expected
 * format "yyyy-MM-dd HH:mm:ss"
 *
 * @author yueli
 * @date 2020/9/11 16:23
 */
@ControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BizException.class)
    public ResponseData bizExceptionHandler(HttpServletRequest request, HttpServletResponse response, BizException ex) {
        exceptionHandlerLog(request, ex);
        BizException bizException = (BizException) ex;
        return ResponseData.fail(bizException.getErrorCode(), bizException.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResponseData nullPointerExceptionHandler(HttpServletRequest request, NullPointerException ex) {
        exceptionHandlerLog(request, ex);

        return ResponseData.fail(ResponseEnum.NULL_POINTER_EXCEPTION.getCode(),
                ResponseEnum.NULL_POINTER_EXCEPTION.getMsg());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseData constraintViolationExceptionHandler(HttpServletRequest request,
                                                            ConstraintViolationException ex) {
        exceptionHandlerLog(request, ex);
        String msg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
        String[] msgs = msg.split(": ");
        return ResponseData.fail(ResponseEnum.CONSTRAINT_VIOLATION_EXCEPTION.getCode(), msgs[msgs.length - 1]);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseData missingServletRequestParameterExceptionHandler(HttpServletRequest request,
                                                                       MissingServletRequestParameterException ex) {
        exceptionHandlerLog(request, ex);
        return ResponseData.fail(ResponseEnum.MISSING_REQUEST_PARAMETER_EXCEPTION.getCode(),
                ResponseEnum.MISSING_REQUEST_PARAMETER_EXCEPTION.getMsg());
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    @ResponseBody
    public ResponseData httpClientErrorExceptionHandler(HttpServletRequest request,
                                                        HttpClientErrorException ex) {
        exceptionHandlerLog(request, ex);
        return ResponseData.fail(ResponseEnum.HTTPCLIENT_ERROR_EXCEPTION.getCode(),
                ResponseEnum.HTTPCLIENT_ERROR_EXCEPTION.getMsg());
    }

    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseBody
    public ResponseData illegalStateExceptionHandler(HttpServletRequest request,
                                                     IllegalStateException ex) {
        exceptionHandlerLog(request, ex);

        String exceptionMsg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
        String exMsgType = "MEDICAL";
        if (null != exceptionMsg && exceptionMsg.indexOf(exMsgType) > 0) {
            ResponseData.fail(ResponseEnum.REMOTE_HTTP_ERROR.getCode(), "基础服务升级中、请稍后再试");
        }
        return ResponseData.fail(ResponseEnum.REMOTE_HTTP_ERROR.getCode(), exceptionMsg);
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    @ResponseBody
    public ResponseData invalidFormatExceptionHandler(HttpServletRequest request,
                                                      InvalidFormatException ex) {
        exceptionHandlerLog(request, ex);
        return ResponseData.fail(ResponseEnum.INVALID_FORMAT_EXCEPTION.getCode(),
                ResponseEnum.INVALID_FORMAT_EXCEPTION.getMsg());
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData exceptionHandler(HttpServletRequest request, Exception ex) {
        exceptionHandlerLog(request, ex);
        return ResponseData.fail(ResponseEnum.UNKNOWN_EXCEPTION.getCode(), ResponseEnum.UNKNOWN_EXCEPTION.getMsg());
    }


    private void exceptionHandlerLog(HttpServletRequest request, Exception ex) {
        // 请求Url
        String requestUrl = request.getRequestURI().toString();
        //请求方法名称
        String method = request.getMethod();
        // 异常信息：
        String exceptionMsg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
        log.info("统一异常处理：requestUrl = {}, method = {}, exceptionMsg = {}, ex = {}", requestUrl, method, exceptionMsg,
                ex);
    }


}
