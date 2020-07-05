package com.decathlon.movie_api.Controller;

import com.decathlon.movie_api.Model.Top;
import com.decathlon.movie_api.Model.TopInterface;
import com.decathlon.movie_api.Repository.CommentRepository;
import com.decathlon.movie_api.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/top")
public class TopController {

    @Autowired
    private CommentRepository commentRepo ;

    @Autowired
    private MovieRepository movieRepo ;

    @GetMapping
    public List<TopInterface> filterFromDate(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
       return commentRepo.filter(start, end);
    }
}
