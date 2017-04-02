package com.hihoall.entity;

/**
 * Created by Brightsunrise on 17.03.2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @Column(name = "username", unique = true,
            nullable = false, length = 20)
    @NotEmpty(message = "{username.notempty.error}")
    @Size(min = 4, max = 20, message = "{username.size.error}")
    @Pattern(regexp="[a-zA-Z_][a-zA-Z0-9_]*", message="{username.reg.error}")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "{password.notempty.error}")
    @Size(min = 4, max = 100, message = "{password.size.error}")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "username_map"),
            inverseJoinColumns = @JoinColumn(name = "rolename_map"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    //    @Column(name = "enabled")
//    private int enabled;

    public User() {
//        enabled = 1;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(int enabled) {
//        this.enabled = enabled;
//    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
//                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", enabled=" + enabled +
                '}';
    }
}
