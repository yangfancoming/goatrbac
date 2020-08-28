package com.goat.rbac.goatrbac.system.exception;


import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(SQLException.class)
    public ResponseBo handleSQLException(Exception e) {
        log.error(e.getMessage());
        return ResponseBo.error("SQL异常 ！"+ e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseBo handleNotFoundException(NotFoundException e) {
        log.error(e.getMessage());
        return ResponseBo.error("IOException ！" + HttpStatus.NOT_FOUND.value()+ e.getMessage());
    }

    /**  处理IO 异常*/
    @ExceptionHandler(IOException.class)
    public ResponseBo iOException(IOException e) {
        log.error(e.getMessage());
        return ResponseBo.error("IOException ！"+ e.getMessage());
    }

    /**  处理 DuplicateKeyException 异常*/
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseBo duplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage());
        return ResponseBo.error("表主键重复！"+ e.getMessage());
    }

    /**  处理 RuntimeException 异常*/
    @ExceptionHandler(RuntimeException.class)
    public ResponseBo runtimeException(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseBo.error("操作失败！");
    }

    //    方法 defaultErrorHandler() 就会处理所有 Controller 层抛出的 Exception 及其子类的异常，这是最基本的用法了
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBo defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.error(e.getMessage());
        return ResponseBo.error("操作失败！Exception" + e.getMessage());
    }




}

