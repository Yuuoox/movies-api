package com.decathlon.movie_api;


import com.decathlon.movie_api.Controller.MovieController;
import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Repository.MovieRepository;
import com.decathlon.movie_api.Service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void getMovies() throws Exception {
        this.mockMvc.perform(get("/movies/"))
                .andExpect(status().isOk());
    }

    @Test
    public void postMovie() throws Exception {
        this.mockMvc.perform(post("/movies/").contentType(MediaType.APPLICATION_JSON)
                .content("Gravity")).andExpect(status().isCreated());
    }

    @Test
    public void putMovie() throws Exception {
        List<Movie> movieList = movieRepository.findAll();
        if (!movieList.isEmpty())
            this.mockMvc.perform(put("/movies/" + movieList.get(0).getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \"title\" : \"mise à jour test\""))
                    .andExpect(status().isOk());
    }

    @Test
    public void deleteMovie() throws Exception {
        List<Movie> movieList = movieRepository.findAll();
        if (!movieList.isEmpty())
            this.mockMvc.perform(delete("/movies/" + movieList.get(0).getId()))
                    .andExpect(status().isNoContent());
    }

}
