package com.valunskii.foxminded.university.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class LoggerAspect {

    private static Logger aspectlog = LoggerFactory.getLogger(LoggerAspect.class);
    private StringBuilder methodsTrace = new StringBuilder();

    @Pointcut("execution(* *(..)) && !execution(* com.valunskii.foxminded.university.aspect.*.* (..))")
    public void myTraceCall() {
    }

    @Before("myTraceCall()")
    public void beforeMethod(JoinPoint joinPoint) {
        createLogger(joinPoint, "before", null, null);
    }

    @AfterReturning(value = "myTraceCall()", returning = "ret")
    public void logReturnMethod(Object ret, JoinPoint joinPoint) {
        createLogger(joinPoint, "return", ret, null);
    }

    @AfterThrowing(value = "myTraceCall()", throwing = "ex")
    public void logMethodThrewException(Exception ex, JoinPoint joinPoint) {
        createLogger(joinPoint, "threw", null, ex);
    }

    private void createLogger(JoinPoint joinPoint, String adviceType, Object returnedObject, Exception thrownException) {
        String[] substrings = getMessageSubstrings(adviceType, returnedObject, thrownException);
        try {
            Logger injectedLog = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
            methodsTrace
                    .append(joinPoint.getTarget().getClass().getSimpleName())
                    .append(".")
                    .append(joinPoint.getSignature().getName())
                    .append("() / ");
            StringBuilder message = new StringBuilder();
            message
                    .append(substrings[0])
                    .append(joinPoint.getTarget().getClass().getSimpleName())
                    .append(".")
                    .append(joinPoint.getSignature().getName());
            Object[] args = joinPoint.getArgs();
            if (args.length > 0) {
                message.append(" WITH ARGS ").append(Arrays.toString(args));
            }
            message.append(substrings[1]);
            injectedLog.debug(message.toString());
        } catch (NullPointerException e) {
            methodsTrace
                    .append(" getting target class for aspect logging threw NPE /");
            aspectlog.warn("INSIDE_ASPECT_LOGGING_EXCEPTION : " + methodsTrace.toString());
            e.printStackTrace();
            methodsTrace = new StringBuilder();
        }
    }

    private String[] getMessageSubstrings(String adviceType, Object returnedObject, Exception thrownException) {
        String[] substrings = new String[2];
        if ("before".equals(adviceType)){
            substrings[0] = "STARTING ";
            substrings[1] = "";
        }
        if ("return".equals(adviceType)){
            substrings[0] = "METHOD ";
            substrings[1] = " RETURNED " + returnedObject;
        }
        if ("threw".equals(adviceType)){
            substrings[0] = "METHOD ";
            substrings[1] = " THREW " + thrownException;
        }
        return substrings;
    }
}
