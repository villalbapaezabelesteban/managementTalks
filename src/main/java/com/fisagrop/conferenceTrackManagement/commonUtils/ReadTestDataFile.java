package com.fisagrop.conferenceTrackManagement.commonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadTestDataFile {
	
	private List<String> fileLines;
	
	public void fromPath(String path) {		
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            this.fileLines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public List<String> getProposals() {
		return this.fileLines;
	}
}