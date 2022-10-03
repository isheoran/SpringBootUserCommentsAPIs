package com.SpringJDBC.SpringJDBC.Service;

import com.SpringJDBC.SpringJDBC.Dao.CommentDao;
import com.SpringJDBC.SpringJDBC.Entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao;

    public CommentServiceImpl(){}

    @Override
    public boolean addComment(Comment comment) {
        comment = new Comment(comment.getUser_id(),comment.getText());
        commentDao.createTable();
        return commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getAllComments(String userId) {
        return commentDao.getAllComments(userId);
    }

    @Override
    public List<Comment> getComments(String userId,Integer count) {
        return commentDao.getAllComments(userId);
    }

    @Override
    public boolean deleteComment(String commentId) {
        return commentDao.deleteComment(commentId);
    }

    @Override
    public List<Comment> getCommentsBetween(String userId,List<String>dates) {
        return commentDao.getCommentsBetween(userId,dates);
    }

    @Override
    public List<Comment> getSortedComments(String userId) {
        return commentDao.getSortedComments(userId);
    }
}
