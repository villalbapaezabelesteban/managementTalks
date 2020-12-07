package com.fisagrop.conferenceTrackManagement.service;

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
		this.talks = this.proposals.parallelStream()
					.map(proposal -> createTalk(proposal))
					.collect(Collectors.toList());
	}
	
	private Talk createTalk(String proposal) {
		return new Talk(ProposalFormatUtil.giveProposalDuration(proposal), 
						ProposalFormatUtil.giveProposalDescription(proposal));
	}
	
	public List<Talk> givenTalks() {
		return this.talks;
	}
}