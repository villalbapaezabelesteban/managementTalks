package com.fisagrop.conferenceTrackManagement.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fisagrop.conferenceTrackManagement.domain.SessionTrack;
import com.fisagrop.conferenceTrackManagement.domain.Talk;
import com.fisagrop.conferenceTrackManagement.domain.Track;

public class SessionTrackManagement {
	
	private static final LocalTime START_MORNING_SESSION = LocalTime.of(9, 0);
	private static final LocalTime START_AFTERNOON_SESSION = LocalTime.of(13, 0);
	private static final LocalTime START_LUNCH_SESSION = LocalTime.of(12, 0);
	
	private static final LocalTime END_MORNING_SESSION = LocalTime.of(12, 0);
	private static final LocalTime END_AFTERNOON_SESSION = LocalTime.of(17, 0);
	private static final LocalTime END_LUNCH_SESSION = LocalTime.of(13, 0);
	
	private TalkManagement talkManagement;

	public SessionTrackManagement(List<String> proposals) {
		this.talkManagement = new TalkManagement(proposals);
	}

	public void generateSessionTracksFor(Track track) {
		SessionTrack morningSession = this.generateMorningSession();
		SessionTrack lunchSession = this.generateLunchSession();
		SessionTrack afternoon = this.generateAfternoonSession();
		
		List<SessionTrack> sessionTracks = Arrays.asList(morningSession, lunchSession, afternoon);
		
		track.addSessionTracks(sessionTracks);
	}
	
	private SessionTrack generateAfternoonSession() {		
		return this.generateSessionTrack(START_AFTERNOON_SESSION, END_AFTERNOON_SESSION);
	}
	
	private SessionTrack generateLunchSession() {
		return this.generateSessionTrack(START_LUNCH_SESSION, END_LUNCH_SESSION);
	}

	private SessionTrack generateMorningSession() {
		return this.generateSessionTrack(START_MORNING_SESSION, END_MORNING_SESSION);
	}
	
	private SessionTrack generateSessionTrack(LocalTime start, LocalTime end) {
		boolean isAfternoonSession = START_AFTERNOON_SESSION.equals(start);
		boolean isLunchSession = START_LUNCH_SESSION.equals(start);
		
		SessionTrack sessionTrack = new SessionTrack(start, end);
		
		if (!isLunchSession) {			
			List<Talk> usedTalks = new ArrayList<>();		
			
			for (Talk talk : this.talkManagement.givenTalks()) {
				start = start.plusMinutes(talk.getDuration());
				
				if (start.isBefore(end) || start.equals(end)) {
					sessionTrack.addTalk(talk);
					usedTalks.add(talk);
				} else {
					start = start.minusMinutes(talk.getDuration());
				}
			}
			
			if (isAfternoonSession) {
				sessionTrack.addTalk(this.talkManagement.giveNetworkingEvent());
			}
			
			this.talkManagement.removeTalks(usedTalks);			
		} else {
			sessionTrack.addTalk(this.talkManagement.giveLunch());
		}
		
		return sessionTrack;
	}

	public boolean canCreateSessionTrack() {
		return this.talkManagement.existAvailableTalks();
	}
}