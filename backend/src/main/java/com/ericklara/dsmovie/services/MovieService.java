package com.ericklara.dsmovie.services;

import com.ericklara.dsmovie.dto.MovieDTO;
import com.ericklara.dsmovie.entities.Movie;
import com.ericklara.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> result = repository.findAll(pageable);

        return result.map(MovieDTO::new);
    }

    public MovieDTO findById(Long id){
        return new MovieDTO(repository.findById(id).get());
    }
}
