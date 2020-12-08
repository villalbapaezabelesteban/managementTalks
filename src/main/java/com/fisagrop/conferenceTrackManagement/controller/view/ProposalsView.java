package com.fisagrop.conferenceTrackManagement.controller.view;

import java.util.List;

public class ProposalsView {
	
	private List<ProposalView> proposals;
	
	public ProposalsView() {
		super();
	}

	public List<ProposalView> getProposals() {
		return proposals;
	}

	public void setProposals(List<ProposalView> proposals) {
		this.proposals = proposals;
	}
}