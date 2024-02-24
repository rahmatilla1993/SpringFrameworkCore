package org.example.beans;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class TransformAspect {
    @Before("execution(* org.example.beans.Transform.start())")
    public void beforeStart() {
        System.out.println("Starting Counter Program");
    }

    @AfterReturning("execution(* org.example.beans.Transform.start())")
    public void afterRun() {
        System.out.println("End of program");
    }

    @AfterThrowing("execution(* org.example.beans.Transform.start())")
    public void afterThrow() {
        System.out.println("Exception occurred!");
    }
}
