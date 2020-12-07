package com.fisagrop.conferenceTrackManagement.service;

import java.util.Arrays;

import com.fisagrop.conferenceTrackManagement.domain.SessionTrack;
import com.fisagrop.conferenceTrackManagement.domain.Track;

public class SessionTrackManagement {
	
	private TalkManagement talkManagement;

	public SessionTrackManagement(TalkManagement talkManagement) {
		this.talkManagement = talkManagement;
	}

	public void createSessionTracksFor(Track track) {
		SessionTrack morningSession = this.createMorningSession();
		SessionTrack afternoon = this.createAfternoonSession();
		
		track.addSessionTracks(Arrays.asList(morningSession, afternoon));
	}
	
	private SessionTrack createAfternoonSession() {
		Integer start = 900;
		SessionTrack afternoonSession = new SessionTrack(start);
		
		this.talkManagement.givenTalks()
		.parallelStream()
		.forEach(talk -> afternoonSession.addTalk(talk));
		
		return afternoonSession;
	}

	private SessionTrack createMorningSession() {
		Integer start = 1300;
		SessionTrack morningSession = new SessionTrack(start);
		
		this.talkManagement.givenTalks()
		.parallelStream()
		.forEach(talk -> morningSession.addTalk(talk));
		
		return morningSession;
	}
}