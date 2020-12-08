package com.fisagrop.conferenceTrackManagement.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fisagrop.conferenceTrackManagement.controller.view.SessionTrackView;
import com.fisagrop.conferenceTrackManagement.domain.SessionTrack;

public class SessionTrackMapper {
	
	public static SessionTrackView mapperToView(SessionTrack sessionTrack) {
        SessionTrackView sessionTrackView = new SessionTrackView();
        sessionTrackView.setTalksView(TalkMapper.mapperToView(sessionTrack.getTalks()));
        return sessionTrackView;
    }

    public static List<SessionTrackView> mapperToView(List<SessionTrack> tracks) {
        return tracks.stream()
                .map(SessionTrackMapper::mapperToView)
                .collect(Collectors.toList());
    }
}