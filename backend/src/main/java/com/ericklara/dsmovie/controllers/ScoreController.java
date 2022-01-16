package com.ericklara.dsmovie.controllers;

import com.ericklara.dsmovie.dto.MovieDTO;
import com.ericklara.dsmovie.dto.ScoreDTO;
import com.ericklara.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
        return service.saveScore(scoreDTO);
    }
}
