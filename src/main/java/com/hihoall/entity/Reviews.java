package com.hihoall.entity;

import javax.persistence.*;

/**
 * Created by Brightsunrise on 30.12.2016.
 */

@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="review_name")
    private String review_name;

    @Column(name="review_email")
    private String review_email;

    @Column(name="review_text")
    private String review_text;

    public Reviews() {

    }

    public Reviews(String review_name, String review_email, String review_text) {
        this.review_name = review_name;
        this.review_email = review_email;
        this.review_text = review_text;
    }

    public int getId() {
        return id;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
    }

    public String getReview_email() {
        return review_email;
    }

    public void setReview_email(String review_email) {
        this.review_email = review_email;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", review_name='" + review_name + '\'' +
                ", review_email='" + review_email + '\'' +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}
