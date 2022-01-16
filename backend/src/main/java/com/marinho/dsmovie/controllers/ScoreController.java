package com.marinho.dsmovie.controllers;

import com.marinho.dsmovie.dto.MovieDTO;
import com.marinho.dsmovie.dto.ScoreDTO;
import com.marinho.dsmovie.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {

        return service.saveScore(dto);
    }
}
