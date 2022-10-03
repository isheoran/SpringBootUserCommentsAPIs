package com.SpringJDBC.SpringJDBC.Controller;

import com.SpringJDBC.SpringJDBC.Entities.Comment;
import com.SpringJDBC.SpringJDBC.Entities.User;
import com.SpringJDBC.SpringJDBC.Service.CommentService;
import com.SpringJDBC.SpringJDBC.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @PostMapping("user/signIn")
    public String registerUser(@RequestBody User user) {
        if(userService.registerUser(user)) return "User registered successfully.";
        return "Registration Unsuccessful.";
    }

    @GetMapping("user/logIn")
    public String logIn(@RequestBody User user) {
        return userService.logIn(user);
    }

    @DeleteMapping("user/deleteAccount")
    public boolean deleteAccount(@RequestBody User user) {
        return userService.deleteAccount(user);
    }

    @PutMapping("user/changePassword")
    public String updatePassword(@RequestBody User user) {
        if(userService.updatePassword(user)) return "Password successfully update.";
        return "Password update Unsuccessful";
    }

    @GetMapping("user/comment/{userId}")
    public List<Comment> getCommentsBetween(@PathVariable String userId, @RequestParam(defaultValue = "1999-01-01") String dateStartFrom, @RequestParam(defaultValue = "9999-01-01") String dateEndTo)  {
        List<String>dates = new ArrayList<>();
        dates.add(dateStartFrom);
        dates.add(dateEndTo);
        return commentService.getCommentsBetween(userId,dates);
    }

    @GetMapping("user/comment/{userId}/{count}")
    public List<Comment> getAllComments(@PathVariable String userId,String count) {
        return commentService.getComments(userId,Integer.parseInt(count));
    }

    @PostMapping("user/comment/{userId}/add")
    public boolean addComment(@RequestBody Comment comment,@PathVariable String userId) {
        comment.setUser_id(userId);
        return commentService.addComment(comment);
    }

    @DeleteMapping("user/comment/userId/delete/{commentId}")
    public boolean deleteComment(@PathVariable String commentId) {
        return commentService.deleteComment(commentId);
    }

    @GetMapping("user/comment/{userId}/allcomments")
    public List<Comment> getSortedComments(@PathVariable String userId) {
        return commentService.getSortedComments(userId);
    }
}
