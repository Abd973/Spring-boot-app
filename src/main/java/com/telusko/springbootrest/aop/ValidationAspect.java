package com.telusko.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.telusko.springbootrest.service.JobService.*;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);


//    @Around("execution(* com.telusko.springbootrest.service.JobService.getJobPost(..)) && args(postID)")
//    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
//        if (postId < 0){
//            postId = -postId;
//
//        }
//
//    }



}
