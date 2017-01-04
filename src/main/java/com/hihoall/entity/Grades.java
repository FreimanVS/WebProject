package com.hihoall.entity;

import javax.persistence.*;

/**
 * Created by Brightsunrise on 25.12.2016.
 */

@Entity
@Table(name="grades")
public class Grades {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="idmovie")
    private int idmovie;

    @Column(name="nick")
    private String nick;

    @Column(name="grade")
    private int grade;

    public Grades() {

    }

    public Grades(int idmovie, String nick, int grade) {
        this.idmovie = idmovie;
        this.nick = nick;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", idmovie='" + idmovie + '\'' +
                ", nick='" + nick + '\'' +
                ", grade=" + grade +
                '}';
    }
}
