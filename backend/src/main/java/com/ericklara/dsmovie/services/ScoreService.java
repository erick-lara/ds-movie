package com.ericklara.dsmovie.services;

import com.ericklara.dsmovie.dto.MovieDTO;
import com.ericklara.dsmovie.dto.ScoreDTO;
import com.ericklara.dsmovie.entities.Movie;
import com.ericklara.dsmovie.entities.Score;
import com.ericklara.dsmovie.entities.User;
import com.ericklara.dsmovie.repositories.MovieRepository;
import com.ericklara.dsmovie.repositories.ScoreRepository;
import com.ericklara.dsmovie.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ScoreRepository scoreRepository;

    public ScoreService(
            MovieRepository movieRepository,
            UserRepository userRepository,
            ScoreRepository scoreRepository
    ) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);

        score.setScore(scoreDTO.getScore());

        scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum += s.getScore();
        }

        movie.setScore(sum / movie.getScores().size());
        movie.setCount(movie.getScores().size());

        movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
