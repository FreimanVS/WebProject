package com.hihoall.entity;

import javax.persistence.*;

/**
 * Created by Brightsunrise on 14.12.2016.
 */

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nick")
    private String nick;

    @Column(name="password")
    private String password;

    public Users() {

    }

    public Users(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
