package com.decathlon.movie_api;


import com.decathlon.movie_api.Controller.CommentController;
import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Repository.CommentRepository;
import com.decathlon.movie_api.Repository.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentRepository commentRepository;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void getComments() throws Exception {
        this.mockMvc.perform(get("/comments"))
                .andExpect(status().isOk());
    }

    @Test
    public void postComment() throws Exception {
        List<Movie> movieList = movieRepository.findAll();
        if (!movieList.isEmpty())
            this.mockMvc.perform(post("/comments")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{" +
                            "\"comment\" : \"Film sympa\"," +
                            "\"movie\" : {" +
                            "\"id\" : " + movieList.get(0).getId() +
                            "}" +
                            "}")
            ).andExpect(status().isCreated());
    }

   /* @Test
    public void testTop() throws Exception {
        this.mockMvc.perform(post("/top?start=2020-07-01&end=2020-07-08")
        ).andExpect(status().isOk());
    }*/

}

