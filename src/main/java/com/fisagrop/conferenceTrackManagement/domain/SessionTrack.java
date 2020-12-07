package com.fisagrop.conferenceTrackManagement.domain;

import java.util.ArrayList;
import java.util.List;

public class SessionTrack {

	private Integer start;
	private List<Talk> talks;

	public SessionTrack(Integer start) {
		this.start = start;
		this.talks = new ArrayList<>();
	}

	public void addTalk(Talk talk) {
		this.talks.add(talk);
	}
}