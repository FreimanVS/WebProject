package com.hihoall.entity;

import javax.persistence.*;

/**
 * Created by Brightsunrise on 17.12.2016.
 */

@Entity
@Table(name="movies")
public class Movies {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idmovie")
    private int idmovie;

    @Column(name="namemovie")
    private String namemovie;

    @Column(name="timefilmed")
    private String timefilmed;

    @Column(name="rating")
    private Float rating;

    @Column(name="amountofvoters")
    private int amountofvoters;

    @Column(name="description")
    private String description;

    @Column(name="director")
    private String director;

    @Column(name="logo")
    private String logo;

    @Column(name="video")
    private String video;

    public Movies() {

    }

    public Movies(String namemovie, String timefilmed, String description, String director, String logo, String video) {
        this.namemovie = namemovie;
        this.timefilmed = timefilmed;
        this.rating = 0.0F;
        this.amountofvoters = 0;
        this.description = description;
        this.director = director;
        this.logo = logo;
        this.video = video;
    }

    public int getIdmovie() {
        return idmovie;
    }

    public String getNamemovie() {
        return namemovie;
    }

    public void setNamemovie(String namemovie) {
        this.namemovie = namemovie;
    }

    public String getTimefilmed() {
        return timefilmed;
    }

    public void setTimefilmed(String timefilmed) {
        this.timefilmed = timefilmed;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getAmountofvoters() {
        return amountofvoters;
    }

    public void setAmountofvoters(int amountofvoters) {
        this.amountofvoters = amountofvoters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "idmovie=" + idmovie +
                ", namemovie='" + namemovie + '\'' +
                ", timefilmed='" + timefilmed + '\'' +
                ", rating=" + rating +
                ", amountofvoters=" + amountofvoters +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", logo='" + logo + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
