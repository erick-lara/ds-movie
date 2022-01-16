package com.ericklara.dsmovie.repositories;

import com.ericklara.dsmovie.entities.Score;
import com.ericklara.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
