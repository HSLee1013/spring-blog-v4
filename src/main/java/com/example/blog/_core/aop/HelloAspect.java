package com.example.blog._core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hello(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Integer) {
                Integer id = (Integer) arg;
                System.out.println(id + "번아 안녕");
            }
        }
    }
}
