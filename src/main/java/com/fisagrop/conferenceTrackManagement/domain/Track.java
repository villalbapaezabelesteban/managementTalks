package com.fisagrop.conferenceTrackManagement.domain;

import java.util.List;

public class Track {	
	
	private List<SessionTrack> addSessionTracks;

	public void addSessionTracks(List<SessionTrack> sessionTracks) {
		this.addSessionTracks = sessionTracks;
	}

}