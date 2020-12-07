package com.fisagrop.conferenceTrackManagement.domain;

import java.util.Objects;

public class Talk {

	private Long duration;
	private String description;

	public Talk(Long duration, String description) {
		this.duration = duration;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public Long getDuration() {
		return this.duration;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Talk)) return false;
		
		Talk talk = (Talk) obj;
		
		return 	Objects.equals(this.duration, talk.getDuration()) && 
				Objects.equals(this.description, talk.getDescription());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.duration, this.description);
	}
}