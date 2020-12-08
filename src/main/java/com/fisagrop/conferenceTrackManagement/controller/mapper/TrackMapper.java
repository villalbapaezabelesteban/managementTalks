package com.fisagrop.conferenceTrackManagement.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fisagrop.conferenceTrackManagement.controller.view.TrackView;
import com.fisagrop.conferenceTrackManagement.domain.Track;

public class TrackMapper {
	
	public static TrackView mapperToView(Track track) {
        TrackView truckView = new TrackView();
        truckView.setSessionTracksView(SessionTrackMapper.mapperToView(track.getSessionTracks()));
        return truckView;
    }

    public static List<TrackView> mapperToView(List<Track> tracks) {
        return tracks.stream()
                .map(TrackMapper::mapperToView)
                .collect(Collectors.toList());
    }
}