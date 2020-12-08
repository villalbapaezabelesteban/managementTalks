package com.fisagrop.conferenceTrackManagement.service;

import java.util.ArrayList;
import java.util.List;

import com.fisagrop.conferenceTrackManagement.domain.Track;

public class TrackManagement {

	private SessionTrackManagement sessionTrackManagement;
	
	private List<Track> trucks;
	
	private TrackManagement() {
		super();
		this.trucks = new ArrayList<>();
	}
	
	public TrackManagement(List<String> proposals) {
		this();
		this.sessionTrackManagement = new SessionTrackManagement(proposals);
		this.createTracks();
	}

	private void createTracks() {
		while (this.canCreateTrack()) {
			Track track = this.generateNewTrack();
			this.sessionTrackManagement.generateSessionTracksFor(track);
			this.add(track);
		}
	}
	
	private Track generateNewTrack() {
		return new Track();
	}
	
	private void add(Track track) {
		this.trucks.add(track);
	}

	public List<Track> getTrucks() {
		return this.trucks;
	}
	
	public boolean canCreateTrack() {
		return this.sessionTrackManagement.canCreateSessionTrack();
	}
}