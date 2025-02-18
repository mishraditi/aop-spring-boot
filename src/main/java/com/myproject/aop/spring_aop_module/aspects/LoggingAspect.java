    package com.myproject.aop.spring_aop_module.aspects;

    import org.aspectj.lang.JoinPoint;
    import org.aspectj.lang.annotation.*;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.context.annotation.Configuration;
    @Configuration
    @Aspect
    public class LoggingAspect {
        private Logger logger = LoggerFactory.getLogger(getClass());

        //Pointcut - When?
        // execution(* PACKAGE.*.*(..))
        @Before("execution(* com.myproject.aop.spring_aop_module.business.*.*(..))")//WHEN
        public void logMethodCall(JoinPoint joinPoint) {
            logger.info("Before Aspect - {} is called with arguments: {}"
                    ,  joinPoint, joinPoint.getArgs());//WHAT
        }
        @After("execution(* com.myproject.aop.spring_aop_module.*.*.*(..))")
        public void logMethodCallAfterExecution(JoinPoint joinPoint) {
            logger.info("After Aspect - {} has executed",  joinPoint);
        }
        @AfterThrowing(
                pointcut ="execution(* com.myproject.aop.spring_aop_module.business.*.*(..))",
                throwing = "exception"
        )
        public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
            logger.error("AfterThrowing Aspect - {} has thrown an exception {}"
                    ,  joinPoint, exception);
        }

        @AfterReturning(
                pointcut ="execution(* com.myproject.aop.spring_aop_module.business.*.*(..))",
                returning = "resultValue"
        )
        public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,
                                                          Object resultValue) {
            logger.info("AfterReturning Aspect - {} has returned {}"
                    ,  joinPoint, resultValue);
        }

    }
