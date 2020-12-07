package com.fisagrop.conferenceTrackManagement.domain;

import java.util.ArrayList;
import java.util.List;

public class Track {	
	
	private List<SessionTrack> sessionTracks;
	
	public Track() {
		this.sessionTracks = new ArrayList<>();
	}

	public void addSessionTracks(List<SessionTrack> sessionTracks) {
		this.sessionTracks = sessionTracks;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("\nTRACK ");
		
		this.sessionTracks
		.parallelStream()
		.forEach(sessionTrack -> builder.append(sessionTrack.toString()));
		
		return builder.toString();
	}
}