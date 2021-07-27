package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
public class Logger {

    @Pointcut("execution(* com.codegym.controller.BookController.borrow(..))")
    public void borrowPointcut() {
    }

    @AfterReturning("borrowPointcut()")
    public void callBorrowPointcut(JoinPoint joinPoint) {
        System.err.println("Amount Book Change -1 ; " + "Class: " + joinPoint.getSignature().getDeclaringTypeName() +
                " ; " + " Method : " + joinPoint.getSignature().getName() +
                " ; " + " Time: " + LocalDate.now());
    }

    @Pointcut("execution(* com.codegym.controller.BookController.retrospectBook(..))")
    public void retrospectBookPointcut() {
    }

    @AfterReturning("retrospectBookPointcut()")
    public void callRetrospectBookPointcut(JoinPoint joinPoint) {
        System.err.println("Amount Book Change + 1 ; " + "Class: " + joinPoint.getSignature().getDeclaringTypeName() +
                " ; " + " Method : " + joinPoint.getSignature().getName() +
                " ; " + " Time: " + LocalDate.now());
    }


    @AfterThrowing(pointcut = "execution(public * com.codegym.controller.BookController.borrow(..))", throwing = "e")
    public void logBorrowException(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println(String.format("Exception: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

    static int count = 0;

    @Pointcut("within(com.codegym.controller.BookController*)")
    public void addAllMethodsPointcut() {
    }

    @After("addAllMethodsPointcut()")
    public void callAllMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("Time : " + LocalDate.now() + " ; " +
                " Method : " + joinPoint.getSignature().getName() +
                " ; " + " Number of visits: " + count);
    }
}
