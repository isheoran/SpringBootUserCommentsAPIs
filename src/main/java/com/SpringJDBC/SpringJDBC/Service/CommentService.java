package com.SpringJDBC.SpringJDBC.Service;

import com.SpringJDBC.SpringJDBC.Entities.Comment;

import java.util.List;

public interface CommentService {
    public boolean addComment(Comment comment);
    public List<Comment> getAllComments(String userId);
    public List<Comment> getComments(String userId,Integer count);
    public boolean deleteComment(String comment_id);
    public List<Comment> getCommentsBetween(String userId,List<String>dates);
    public List<Comment> getSortedComments(String userId);
}
