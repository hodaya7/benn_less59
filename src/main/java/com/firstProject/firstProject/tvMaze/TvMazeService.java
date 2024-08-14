package com.firstProject.firstProject.tvMaze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//less 65
@FeignClient(
        name= "TvMazeService",
        url= "${externalApi.tvMaze.url}"
)
public interface TvMazeService {

    @GetMapping("/shows/{tvShowId}")
    TvMazeShowResponse getTvShowById(@PathVariable Long tvShowId);
}
