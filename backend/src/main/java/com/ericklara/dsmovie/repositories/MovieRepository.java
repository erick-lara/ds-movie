package com.ericklara.dsmovie.repositories;

import com.ericklara.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
