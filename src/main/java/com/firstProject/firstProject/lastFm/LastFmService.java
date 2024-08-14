package com.firstProject.firstProject.lastFm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name= "LastFmService",
        url= "${externalApi.lastFM.url}"
)//url= "http://ws.audioscrobbler.com/2.0" זה בקובץ יאמל
public interface LastFmService {
    @GetMapping("/")
    LastFmTopArtistsResponse  getTopTracksByArtistName(@RequestParam String method,
                                   @RequestParam String artist,
                                   @RequestParam("api_key") String apiKey,
                                   @RequestParam String format);
}
