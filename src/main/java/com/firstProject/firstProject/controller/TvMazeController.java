package com.firstProject.firstProject.controller;

import com.firstProject.firstProject.model.ShowResponse;
import com.firstProject.firstProject.tvMaze.TvMazeService;
import com.firstProject.firstProject.tvMaze.TvMazeShowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TvMazeController {

    @Autowired
    TvMazeService tvMazeService;

    @GetMapping("/shows/{ShowId}")
    public ShowResponse getTvShowById(@PathVariable Long ShowId){
     return tvMazeService.getTvShowById(ShowId).toShowResponse();
    }
}
