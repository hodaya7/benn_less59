package com.firstProject.firstProject.lastFm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LastFmTopTracks {
    @JsonProperty("track")
    private List<LastFmTrack> trackList;

    public LastFmTopTracks() {
    }

    public LastFmTopTracks(List<LastFmTrack> trackList) {
        this.trackList = trackList;
    }

    public List<LastFmTrack> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<LastFmTrack> trackList) {
        this.trackList = trackList;
    }
}
