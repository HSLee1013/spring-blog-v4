package com.example.blog._core.error;

import com.example.blog._core.error.ex.Exception400;
import com.example.blog._core.error.ex.Exception404;
import com.example.blog._core.util.Resp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 예외처리
@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> err400(Exception400 e) {
        ResponseEntity responseEntity = new ResponseEntity(Resp.fail(e.getMessage()), HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> err404(Exception404 e) {
        ResponseEntity responseEntity = new ResponseEntity(Resp.fail(e.getMessage()), HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
