package com.fisagrop.conferenceTrackManagement.controller.view;

public class TalkView {
	
	private Long duration;
	private String description;
	
	public TalkView() {
		super();
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}