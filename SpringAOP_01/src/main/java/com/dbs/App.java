package com.dbs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dbs.config.AppConfig;
import com.dbs.beans.Person;
import com.dbs.service.PersonService;

public class App {
    public static void main(String[] args)
    {
      ApplicationContext ctxt=new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService=ctxt.getBean(PersonService.class);
        Person p1=personService.getPerson();
        System.out.println(p1);
        System.out.println(personService.getHello());
    }
}
