package com.dbs.dap;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dbs.entity.Person;
import com.dbs.entity.PersonRowMapper;
import com.dbs.exception.InvalidPersonIdException;

@Component

public class PersonDao {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person find(int id) throws InvalidPersonIdException {
        String sql = "select * from person where id=?";
        try {
            Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, new PersonRowMapper());
            return person;
        } catch (EmptyResultDataAccessException e) {
            throw new InvalidPersonIdException("Person ID is not valid: " + id);
        }
    }

    public List<Person> findAll() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    public boolean save(Person person) {
        String sql = "insert into person values (" + person.getId() + ",'" + person.getName() + "'," + person.getSalary() + ")";
        if (jdbcTemplate.update(sql) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(Person person) {
        String sql = "update person set name=?, salary=? where id=?";
        int norecords = jdbcTemplate.update(sql, new Object[] {person.getName(), person.getSalary(), person.getId()}, new int[]{Types.VARCHAR,Types.DOUBLE,Types.INTEGER});
        if (norecords == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "delete from person where id=? ";
        if (jdbcTemplate.update(sql, new Object[]{id}) == 1) {
            return true;
        } else {
            return false;
        }
    }
}

