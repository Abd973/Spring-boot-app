package com.telusko.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import com.telusko.springbootrest.model.JobPost;


@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class-name.method-name(args)

    @Before("execution(* com.telusko.springbootrest.service.JobService.getJobPost(..))")
    public void logMethodCall(JoinPoint jP) {
        LOGGER.info("Method \"" + jP.getSignature().getName() + "\" get called");
    }


    @After("execution(* com.telusko.springbootrest.service.JobService.getJobPost(..))")
    public void logMethodExecuted(JoinPoint jP) {
        LOGGER.info("Method \"" + jP.getSignature().getName() + "\" get executed");
    }
}
