package com.fisagrop.conferenceTrackManagement.controller.view;

import java.util.List;

public class SessionTrackView {
	
	private List<TalkView> talksView;
	
	public SessionTrackView() {
		super();
	}

	public List<TalkView> getTalksView() {
		return talksView;
	}

	public void setTalksView(List<TalkView> talksView) {
		this.talksView = talksView;
	}
}