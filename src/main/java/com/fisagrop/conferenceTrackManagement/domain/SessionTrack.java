package com.fisagrop.conferenceTrackManagement.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SessionTrack {
	
	private LocalTime start;
	private LocalTime end;
	private List<Talk> talks;

	public SessionTrack(LocalTime start, LocalTime end) {
		this.start = start;
		this.end = end;
		this.talks = new ArrayList<>();
	}

	public void addTalk(Talk talk) {
		this.talks.add(talk);
	}
	
	public LocalTime getEnd() {
		return this.end;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		LocalTime hour = LocalTime.of(this.start.getHour(), this.start.getMinute());
		
		for (Talk talk : this.talks) {
			builder.append("\n")
			.append(hour.format(DateTimeFormatter.ofPattern("HH:mm")))
			.append(" ")
			.append(talk.getDescription());
			
			hour = hour.plusMinutes(talk.getDuration());
		}
		
		return builder.toString();
	}
}