package com.dbs.app;

import com.dbs.entity.Person;
import com.dbs.app.*;
import com.dbs.entity.PersonRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App_01 {
    public static void main(String[] args){
        ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = ctxt.getBean(JdbcTemplate.class);
/*
Person person = new Person(102,"Harshini",50000.00);
String sql = "insert into person values ("+person.getId()+",'"+person.getName()+"',"+person.getSalary()+")";
if(jdbcTemplate.update(sql)==1){
System.out.println("Insertion Successfull");
}
else{
System.out.println("Insertion failed");
}
*/

String sql = "select * from person where id = ?";
Person person = jdbcTemplate.queryForObject(sql, new Object[] {101} , new PersonRowMapper());
System.out.println(person);

/*
  String sql = "select * from person";
   List<Person> persons = jdbcTemplate.query(sql, new PersonRowMapper());
        for(Person person : persons)
        {
            System.out.println(person);
        }
        */
    }
}

