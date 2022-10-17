package com.global.hr.repository.impl;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeNamedParameterJDBCRepo implements EmployeeReps {

    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;


    @Override
    public int count() {
  //      return namedParameterJdbcTemplate.querforobject("select count(*)from employees",Integer.class);
    }

    @Override
    public Employee findById(long id) {
        return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employees where id = :id",
                new MapSqlParameterSource("id",id)
                , new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
       // return jdbcTemplate.query("select id, name, salary from employees", new EmployeeMapper());
            return  null;
    }

    @Override
    public int insert(Employee employee) {
        return namedParameterJdbcTemplate.update("insert into employees (id, name, salary) values (:,:,:)",
                new Object [] {employee.getEmployeeid(), employee.getName(), employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employees set name= ? , salary = ?",
                new Object [] {employee.getName(), employee.getSalary()});
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("delete from employees where id = ?",
                new Object [] {id});
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, Double salary) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
