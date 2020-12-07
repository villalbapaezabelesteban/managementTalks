package com.fisagrop.conferenceTrackManagement.commonUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ProposalFormatUtil {
	
	private static Pattern REGULAR_PROPOSAL_PATTERN = Pattern.compile("([0-9]*min$)");
	private static Pattern LIGHTNING_PROPOSAL_PATTERN = Pattern.compile("(lightning$)");
	private static Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*)");
	private static Pattern DESCRIPTION_PATTERN = Pattern.compile("(^[a-zA-Z-\\s]*)");
	
	private static Integer LIGHTNING_DURATION = 5;
	
	public static final String giveProposalDescription(String proposal) {
		return Arrays.asList(DESCRIPTION_PATTERN.matcher(proposal))
				.parallelStream()
				.filter(matcher -> matcher.find())
				.findFirst()
				.map(mapper -> mapper.group(0))
				.get();
	}
	
	public static final Integer giveProposalDuration(String proposal) {
		return Arrays.asList(NUMBER_PATTERN.matcher(giveDurationValue(proposal)))
				.parallelStream()
				.filter(matcher -> matcher.find())
				.findFirst()
				.map(mapper -> parseDurationValue(mapper.group(0)))
				.get();
	}
	
	private static final String giveDurationValue(String proposal) {
		return Arrays.asList(	REGULAR_PROPOSAL_PATTERN.matcher(proposal),
								LIGHTNING_PROPOSAL_PATTERN.matcher(proposal))
				.parallelStream()
				.filter(matcher -> matcher.find())
				.findFirst()
				.map(mapper -> mapper.group(1))
				.get();
	}
	
	private static Integer parseDurationValue(String value) {
		Integer parseValue;		
		try {
			parseValue = Integer.valueOf(value);
		} catch (NumberFormatException exception) {
			parseValue = LIGHTNING_DURATION;
		}
		return parseValue;
	}
}