package com.firstProject.firstProject.controller;

import com.firstProject.firstProject.lastFm.LastFmService;
import com.firstProject.firstProject.lastFm.LastFmTopArtistsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {
    private static final String LAST_FM_API_KEY = "b3b285e6d33a53e5ecb28dfc7db566a6";//בעיקרון זה אמור להיות בסרביס עצמו
    private static final String LAST_FM_METHOD = "artist.gettoptracks";
    private static final String LAST_FM_FORMAT = "json";
    @Autowired
    LastFmService lastFmService;

    @GetMapping("/artist/{artistName}")
    public LastFmTopArtistsResponse getTopTracksByArtistName(@PathVariable String artistName){
        return lastFmService.getTopTracksByArtistName(LAST_FM_METHOD, artistName, LAST_FM_API_KEY, LAST_FM_FORMAT);
    }

}
