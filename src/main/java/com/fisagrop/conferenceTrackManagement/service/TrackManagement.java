package com.fisagrop.conferenceTrackManagement.service;

import java.util.List;

import com.fisagrop.conferenceTrackManagement.domain.Track;

public class TrackManagement {

	private TalkManagement talkManagement;
	private SessionTrackManagement sessionTrackManagement;
	
	private List<Track> trucks;

	public TrackManagement(List<String> proposals) {
		this.talkManagement = new TalkManagement(proposals);
		this.sessionTrackManagement = new SessionTrackManagement(this.talkManagement);
		
		this.createTracks();
	}

	private void createTracks() {
		
	}

	public List<Track> getTrucks() {
		return this.trucks;
	}
}