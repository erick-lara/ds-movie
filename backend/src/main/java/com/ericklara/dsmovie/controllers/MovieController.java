package com.ericklara.dsmovie.controllers;

import com.ericklara.dsmovie.dto.MovieDTO;
import com.ericklara.dsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO findAll(@PathVariable Long id){
        return service.findById(id);
    }
}
