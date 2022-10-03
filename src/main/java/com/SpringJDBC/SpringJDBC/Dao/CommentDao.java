package com.SpringJDBC.SpringJDBC.Dao;

import com.SpringJDBC.SpringJDBC.Entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CommentDao(){}

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS Comment(comment_id varchar(250) primary key,user_id varchar(250), date_of_entry date,time_of_entry time,text varchar(500),FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE ON UPDATE CASCADE)";
        jdbcTemplate.update(query);
    }

    public boolean addComment(Comment comment) {
        String query = "INSERT INTO Comment(comment_id,user_id,date_of_entry,time_of_entry,text) VALUES(?,?,?,?,?)";
        if(this.jdbcTemplate.update(query,new Object[]{comment.getComment_id(),comment.getUser_id(),comment.getDate_of_entry(),comment.getTime_of_entry(),comment.getText()})>0) return true;
        return false;
    }

    public List<Comment> getAllComments(String userId) {
        String query = "SELECT * FROM Comment where user_id = ?";
        return this.jdbcTemplate.query(query,new BeanPropertyRowMapper<Comment>(Comment.class),userId);
    }

    public List<Comment> getComments(String userId,Integer count) {
        String query = "SELECT * FROM Comment where user_id = ?";
        List<Comment>res = this.jdbcTemplate.query(query,new BeanPropertyRowMapper<Comment>(Comment.class),userId);
        while(res.size() > count) res.remove(res.size()-1);
        return res;
    }

    public boolean deleteComment(String commentId) {
        String query = "DELETE FROM Comment where comment_id = ?";
        if(jdbcTemplate.update(query,commentId) > 0) return true;
        return false;
    }

    public List<Comment> getCommentsBetween(String userId,List<String>dates) {
        String query = "SELECT * FROM Comment where date_of_entry >= ? and date_of_entry <= ? and user_id = ?";
        return this.jdbcTemplate.query(query,new BeanPropertyRowMapper<Comment>(Comment.class),new Object[]{dates.get(0),dates.get(1),userId});
    }

    public List<Comment> getSortedComments(String userId) {
        String query = "SELECT * FROM Comment where user_id = ? ORDER BY date_of_entry";
        return this.jdbcTemplate.query(query,new BeanPropertyRowMapper<Comment>(Comment.class),userId);
    }
}
