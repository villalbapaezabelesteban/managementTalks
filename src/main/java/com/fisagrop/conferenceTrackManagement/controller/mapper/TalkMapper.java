package com.fisagrop.conferenceTrackManagement.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fisagrop.conferenceTrackManagement.controller.view.TalkView;
import com.fisagrop.conferenceTrackManagement.domain.Talk;

public class TalkMapper {
	
	public static TalkView mapperToView(Talk talk) {
        TalkView talkView = new TalkView();        
        talkView.setDuration(talk.getDuration());
        talkView.setDescription(talk.getDescription());        
        return talkView;
    }

    public static List<TalkView> mapperToView(List<Talk> talks) {
        return talks.stream()
                .map(TalkMapper::mapperToView)
                .collect(Collectors.toList());
    }
}