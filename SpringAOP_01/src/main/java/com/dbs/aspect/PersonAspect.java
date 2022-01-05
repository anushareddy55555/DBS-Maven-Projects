package com.dbs.aspect;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
@Component
@EnableAspectJAutoProxy

public class PersonAspect {
    @Before("execution(public * get*())")
    public void logBefore() {
        System.out.println("This is before getPerson() called");
    }
    @After("execution(public * com.dbs.service.PersonService.*())")
    public void logAfter() {
        System.out.println("This is After getPerson() called");
    }
}
