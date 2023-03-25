package com.logging.app.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingWebReqResp {

    private String methodName;

    @Before(value = "execution(* com.logging.app.*.*.*(..))")
    public void enterIntoLogging(JoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer();
        methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        sb.append("Entering in : ").append(methodName, 0, methodName.lastIndexOf('(') + 1);

        for (int i = 0; i < args.length; i++) {
            if (i != args.length - 1) {
                sb.append(args[i]).append(",");
            } else {
                sb.append(args[i]);
            }
        }
        sb.append(")");
        log.info(sb.toString());

    }

    @AfterReturning(value = "execution(* com.logging.app.*.*.*(..))", returning = "object")
    public void exitingFromLogging(JoinPoint joinPoint, Object object) {
        log.info("Exiting from method: {} which returns: {}", methodName, object);
    }

    @AfterThrowing(value = "execution(* com.logging.app.*.*.*(..))", throwing = "exception")
    public void throwsLogging(JoinPoint joinPoint, RuntimeException exception) {
        log.info("Exception raised inside method: {} and message: {}", methodName , exception.getMessage() != null ? exception.getMessage() : null);
    }

}
