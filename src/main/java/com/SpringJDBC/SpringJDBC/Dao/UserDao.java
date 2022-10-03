package com.SpringJDBC.SpringJDBC.Dao;

import com.SpringJDBC.SpringJDBC.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDao(){}

    public int createTable() {
        String query = "CREATE TABLE IF NOT EXISTS User(id varchar(250) primary key,name varchar(250),email varchar(250),password varchar(250) not null,date_of_account_creation Date)";
        return this.jdbcTemplate.update(query);
    }

    public int insertUser(User user) {
        String query = "INSERT INTO User VALUES(?,?,?,?,?)";
        return this.jdbcTemplate.update(query,new Object[]{user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getDate_of_account_creation()});
    }

    public String findUser(User user) {
        String query = "SELECT id from User where email = ? and password = ?";
        List<User>users = jdbcTemplate.query(query,new BeanPropertyRowMapper<User>(User.class),new Object[]{user.getEmail(),user.getPassword()});
        if(users.isEmpty()) return "does_not_exists";
        return users.get(0).getId();
    }

    public boolean deleteUser(User user) {

        String query = "DELETE FROM User where name = ?, email = ?, password = ?";

        if(jdbcTemplate.update(query,new Object[]{user.getName(),user.getEmail(),user.getPassword()}) > 0) return true;
        return false;
    }

    public boolean updatePassword(User user) {
        String query = "UPDATE User SET password = ? where email = ?";
        if(jdbcTemplate.update(query,new Object[]{user.getPassword(),user.getEmail()})>0) return true;
        return false;
    }
}
