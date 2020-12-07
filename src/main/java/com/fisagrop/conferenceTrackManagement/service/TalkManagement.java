package com.fisagrop.conferenceTrackManagement.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fisagrop.conferenceTrackManagement.commonUtils.ProposalFormatUtil;
import com.fisagrop.conferenceTrackManagement.domain.Talk;

public class TalkManagement {
	
	private List<String> proposals;
	private List<Talk> talks;

	public TalkManagement(List<String> proposals) {
		this.proposals = proposals;
		this.generateTalks();
	}

	private void generateTalks() {
		this.talks = this.proposals.stream()
					.map(proposal -> createTalk(proposal))
					.collect(Collectors.toList());
		this.talks.sort(Comparator
						.comparing(Talk::getDuration)
						.reversed());
	}
	
	private Talk createTalk(String proposal) {
		return new Talk(ProposalFormatUtil.giveProposalDuration(proposal), 
						ProposalFormatUtil.giveProposalDescription(proposal));
	}
	
	public List<Talk> givenTalks() {
		return this.talks;
	}
	
	public void removeTalks(List<Talk> talks) {
		this.talks = this.talks.
						stream()
						.filter(talk -> !talks.contains(talk))
						.collect(Collectors.toList());
	}
	
	public boolean existAvailableTalks() {
		return !this.talks.isEmpty();
	}

	public Talk giveNetworkingEvent() {
		return new Talk(0L, "Networking Event");
	}

	public Talk giveLunch() {
		return new Talk(60L, "Lunch");
	}
}