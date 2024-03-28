//package com.xuanphi.usermanagement.aop;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//    Logger logger = Logger.getLogger(LoggingAspect.class);
////    @Before("execution(* com.xuanphi.aop.service.CalculatorService.add(..))")
////    public void beforeAdd(JoinPoint joinPoint) {
////        System.out.println("Running method Add of Calculator.");
////    }
////
////    @After("execution(* com.xuanphi.aop.service.CalculatorService.add(..))")
////    public void afterAdd(JoinPoint joinPoint) {
////        System.out.println("Method Add of Calculator executed.");
////    }
////
////    @AfterThrowing("execution(* com.xuanphi.aop.service.CalculatorService.*(..))")
////    public void afterThrowingAdd(JoinPoint joinPoint) {
////        System.out.println("Method of Calculator got error.");
////    }
//
//    @Pointcut("execution(* com.xuanphi.usermanagement.service.*(..))")
//    public void myPointcut() {
//        System.out.println("Result: ");
//        logger.info("Result: ");
//    }
//
//    @Before("myPointcut()")
//    public void beforeCalculate(JoinPoint joinPoint) {
//        System.out.println("Running: " + joinPoint.getSignature().getName());
//        logger.info("Running: " + joinPoint.getSignature().getName());
//    }
//
//    @After("myPointcut()")
//    public void afterCalculate(JoinPoint joinPoint) {
//        System.out.println("Done: " + joinPoint.getSignature().getName());
//        logger.info("Done: " + joinPoint.getSignature().getName());
//    }
//
//    @Around("myPointcut()")
//    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        long startTime = System.currentTimeMillis();
//        Object result = proceedingJoinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        long executionTime = endTime - startTime;
//        System.out.println("Result: " + result);
//        System.out.println("Execution time: " + executionTime);
//        logger.info("Result: " + result);
//        logger.info("Execution time: " + executionTime);
//        return result;
//    }
//}
