package com.decathlon.movie_api.Controller;

import com.decathlon.movie_api.Model.Comment;
import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Repository.CommentRepository;
import com.decathlon.movie_api.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepo ;

    @Autowired
    private MovieRepository movieRepo ;

  /*  @GetMapping
    public List<Comment> findAll(){
        return commentRepo.findAll();
    }*/

    @GetMapping
    public List<Comment> findByMovieId(@RequestParam(required = false) String movieId) throws Exception {
        if(movieId == null)
            return commentRepo.findAll();
        Movie movie = movieRepo.findById(Integer.parseInt(movieId));
        if(movie == null)
            throw new Exception("movie not found");
        return commentRepo.findAllByMovie(movie);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) throws Exception {
        Movie movie = movieRepo.findById(comment.getMovie().getId());
        if(movie == null){
            throw new Exception("movie not found");
        }
        comment = commentRepo.save(comment);
        movie.addCommentToList(comment);
        movieRepo.save(movie);
        return comment;
    }
}
