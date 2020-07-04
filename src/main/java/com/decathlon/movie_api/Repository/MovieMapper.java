package com.decathlon.movie_api.Repository;

import com.decathlon.movie_api.Model.Movie;
import com.decathlon.movie_api.Model.MovieDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMovieFromDto(MovieDto dto, @MappingTarget Movie entity);
}
