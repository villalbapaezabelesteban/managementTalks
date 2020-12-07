package com.fisagrop.conferenceTrackManagement.service;

import java.util.ArrayList;
import java.util.List;

import com.fisagrop.conferenceTrackManagement.domain.Track;

public class TrackManagement {

	private SessionTrackManagement sessionTrackManagement;
	
	private List<Track> trucks;

	public TrackManagement(List<String> proposals) {
		this.sessionTrackManagement = new SessionTrackManagement(proposals);
		this.trucks = new ArrayList<>();
	}

	public void createTrack() {
		if (this.canCreateTrack()) {
			Track track = new Track();
			this.sessionTrackManagement.generateSessionTracksFor(track);
			this.trucks.add(track);
		}
	}

	public List<Track> getTrucks() {
		return this.trucks;
	}
	
	public boolean canCreateTrack() {
		return this.sessionTrackManagement.canCreateSessionTrack();
	}
}