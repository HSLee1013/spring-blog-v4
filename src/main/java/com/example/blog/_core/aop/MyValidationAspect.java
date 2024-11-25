package com.example.blog._core.aop;

import com.example.blog._core.error.ex.Exception400;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@Aspect
public class MyValidationAspect {

    // 행위
    @Around(value = "@annotation(org.springframework.web.bind.annotation.PostMapping)") // 포인트컷 자리
    public Object validationCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;
                if (errors.hasErrors()) {
                    String errMsg = errors.getFieldErrors().get(0).getField() + " : " + errors.getFieldErrors().get(0).getDefaultMessage();
                    throw new Exception400(errMsg);
                }
            }
        }
        System.out.println("직전");
        Object object = joinPoint.proceed();
        System.out.println("직후");
        return object;
    }

    @Around(value = "@annotation(org.springframework.web.bind.annotation.PutMapping)") // 포인트컷 자리
    public Object validationCheck2(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;
                if (errors.hasErrors()) {
                    String errMsg = errors.getFieldErrors().get(0).getField() + " : " + errors.getFieldErrors().get(0).getDefaultMessage();
                    throw new Exception400(errMsg);
                }
            }
        }
        System.out.println("직전");
        Object object = joinPoint.proceed();
        System.out.println("직후");
        return object;
    }
}
