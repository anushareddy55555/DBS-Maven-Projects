package com.dbs.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dbs.dap.PersonDao;
import com.dbs.entity.Person;
import com.dbs.exception.InvalidPersonIdException;

public class App_02 {
    public static void main(String[] args) {
        ApplicationContext ctxt=new ClassPathXmlApplicationContext("spring.xml");
        PersonDao personDao=ctxt.getBean(PersonDao.class);
        Person p1=new Person(101,"Pranaya",50000);
        boolean res=personDao.edit(p1);
        System.out.println(res);
    }
}
