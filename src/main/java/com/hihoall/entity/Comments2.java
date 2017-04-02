package com.hihoall.entity;

import javax.persistence.*;

/**
 * Created by Brightsunrise on 14.12.2016.
 */

@Entity
@Table(name="comments2")
public class Comments2 {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="idmovie")
    private int idmovie;

    @Column(name="namemovie")
    private String namemovie;

    @Column(name="timecomment")
    private String timecomment;

    @Column(name="content")
    private String content;

    @Column(name="nick")
    private String nick;

    public Comments2() {}

    public Comments2(int idmovie, String namemovie, String timecomment, String content, String nick) {
        this.idmovie = idmovie;
        this.namemovie = namemovie;
        this.timecomment = timecomment;
        this.content = content;
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    public String getNamemovie() {
        return namemovie;
    }

    public void setNamemovie(String namemovie) {
        this.namemovie = namemovie;
    }

    public String getTimecomment() {
        return timecomment;
    }

    public void setTimecomment(String timecomment) {
        this.timecomment = timecomment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Comments2{" +
                "id=" + id +
                ", idmovie=" + idmovie +
                ", namemovie='" + namemovie + '\'' +
                ", timecomment='" + timecomment + '\'' +
                ", content='" + content + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
