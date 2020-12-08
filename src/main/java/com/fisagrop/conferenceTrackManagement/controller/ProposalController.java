package com.fisagrop.conferenceTrackManagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisagrop.conferenceTrackManagement.controller.mapper.TrackMapper;
import com.fisagrop.conferenceTrackManagement.controller.view.ProposalsView;
import com.fisagrop.conferenceTrackManagement.controller.view.TrackView;
import com.fisagrop.conferenceTrackManagement.service.TrackManagement;

@RestController
@RequestMapping(value = "/proposals", 
				produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ProposalController {
	
	@GetMapping
	public List<TrackView> format(@RequestBody ProposalsView view) {
		TrackManagement trackManagement = new TrackManagement(view.getProposals()
				.stream()
				.map(proposal -> proposal.getDescription())
				.collect(Collectors.toList()));
		List<TrackView> trucksView = TrackMapper.mapperToView(trackManagement.getTrucks());
		return trucksView;
	}
}