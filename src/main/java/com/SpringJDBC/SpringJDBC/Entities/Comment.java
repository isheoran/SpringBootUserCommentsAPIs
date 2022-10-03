package com.SpringJDBC.SpringJDBC.Entities;

import java.sql.Date;
import java.sql.Time;

public class Comment {
    private String comment_id;
    private String user_id;
    private Date date_of_entry;
    private Time time_of_entry;
    private String text;

    public Comment(){}

    public Comment(String user_id,String text) {
        java.util.Date date = new java.util.Date();
        this.comment_id = user_id+text;
        this.user_id = user_id;
        this.date_of_entry = Date.valueOf(""+(date.getYear()+1900)+"-"+date.getMonth()+"-"+date.getDay());
        this.time_of_entry = new Time(date.getTime());
        this.text = text;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getDate_of_entry() {
        return date_of_entry;
    }

    public void setDate_of_entry(Date date_of_entry) {
        this.date_of_entry = date_of_entry;
    }

    public Time getTime_of_entry() {
        return time_of_entry;
    }

    public void setTime_of_entry(Time time_of_entry) {
        this.time_of_entry = time_of_entry;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id='" + comment_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", date_of_entry=" + date_of_entry +
                ", time_of_entry=" + time_of_entry +
                ", text='" + text + '\'' +
                '}';
    }
}
