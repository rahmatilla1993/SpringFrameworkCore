package org.example.beans;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
@Log
public class TransformAspect {

    @Before("execution(* org.example.beans.Transform.start())")
    public void beforeStart() {
        log.info("Starting Counter Program");
    }

    @AfterReturning("execution(* org.example.beans.Transform.start())")
    public void afterRun() {
        log.info("End of program");
    }

    @AfterThrowing(pointcut = "execution(* org.example.beans.Transform.start())", throwing = "exception")
    public void afterThrow(Throwable exception) {
        log.warning(exception.getMessage());
    }
}
