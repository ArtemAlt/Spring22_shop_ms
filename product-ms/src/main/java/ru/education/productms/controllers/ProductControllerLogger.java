package ru.education.productms.controllers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductControllerLogger {
    @Before("execution (public ru.education.productms.models.DTO.ProductDTO " +
            "ru.education.productms.controllers.ProductController.findByName(*))")
    public void beforeRequestFindProductByName(JoinPoint jp){
        MethodSignature ms = (MethodSignature) jp.getSignature();
        System.err.println("AOP: Request - " + ms+" for find product by name");
        Object[] args = jp.getArgs();
        if (args.length > 0) {
            System.err.println("Request params - ");
            for (Object o : args) {
                System.err.println(o);
            }
        }
    }

    @Around("execution (public * ru.education.productms.controllers.ProductController.*(..))")
    public Object timeMethodWork(ProceedingJoinPoint pjp) throws Throwable{
        System.err.println("start profiling");
        long begin = System.currentTimeMillis();
        Object out = pjp.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.err.println(pjp.getSignature() + " duration: " + duration);
        System.err.println("end profiling");
        return out;
    }

}
