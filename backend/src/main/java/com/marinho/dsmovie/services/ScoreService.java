package com.marinho.dsmovie.services;

import com.marinho.dsmovie.dto.MovieDTO;
import com.marinho.dsmovie.dto.ScoreDTO;
import com.marinho.dsmovie.entities.Movie;
import com.marinho.dsmovie.entities.Score;
import com.marinho.dsmovie.entities.User;
import com.marinho.dsmovie.repositories.MovieRepository;
import com.marinho.dsmovie.repositories.ScoreRepository;
import com.marinho.dsmovie.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final MovieRepository movieRepository;

    private final UserRepository userRepository;

    private final ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }
        Double avg = sum / movie.getScores().size();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }
}
