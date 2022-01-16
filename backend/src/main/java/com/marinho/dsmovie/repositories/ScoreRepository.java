package com.marinho.dsmovie.repositories;

import com.marinho.dsmovie.entities.Score;
import com.marinho.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
