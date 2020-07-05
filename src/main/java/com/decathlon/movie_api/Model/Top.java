package com.decathlon.movie_api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Top implements Serializable {

    @JsonProperty("movie_id")
    private int movieId ;

    @JsonProperty("total_comments")
    private int commentsAmount ;

    @JsonProperty("rank")
    private int movieRank ;

    public Top() {
    }

    public Top(int movieId, int commentsAmount, int movieRank) {
        this.movieId = movieId;
        this.commentsAmount = commentsAmount;
        this.movieRank = movieRank;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCommentsAmount() {
        return commentsAmount;
    }

    public void setCommentsAmount(int commentsAmount) {
        this.commentsAmount = commentsAmount;
    }

    public int getMovieRank() {
        return movieRank;
    }

    public void setMovieRank(int movieRank) {
        this.movieRank = movieRank;
    }

    @Override
    public String toString() {
        return "Top{" +
                "movieId=" + movieId +
                ", commentsAmount=" + commentsAmount +
                ", movieRank=" + movieRank +
                '}';
    }
}
