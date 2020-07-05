package com.decathlon.movie_api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String comment ;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie ;

    @Column(name="created_at")
    private Date createdAt;

    public Comment() {
        createdAt = new Date();
    }

    public Comment(String comment, Movie movie, Date createdAt) {
        this.comment = comment;
        this.movie = movie;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", movie=" + movie +
                ", createdAt=" + createdAt +
                '}';
    }
}
