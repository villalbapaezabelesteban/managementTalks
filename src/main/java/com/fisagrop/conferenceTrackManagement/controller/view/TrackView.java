package com.fisagrop.conferenceTrackManagement.controller.view;

import java.util.List;

public class TrackView {
	
	private List<SessionTrackView> sessionTracksView;
	
	public TrackView() {
		super();
	}

	public List<SessionTrackView> getSessionTracksView() {
		return sessionTracksView;
	}

	public void setSessionTracksView(List<SessionTrackView> sessionTracksView) {
		this.sessionTracksView = sessionTracksView;
	}
}