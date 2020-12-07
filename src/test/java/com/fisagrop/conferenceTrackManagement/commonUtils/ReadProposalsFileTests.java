package com.fisagrop.conferenceTrackManagement.commonUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadProposalsFileTests {
	
	private static final String PROPOSALS_FILE_PATH = 	"src"
														.concat(File.separator)
														.concat("test")
														.concat(File.separator)
														.concat("data")
														.concat(File.separator)
														.concat("proposalsFile.txt");
	
	@Test
	public void readingFileWithExistInputPathTest() {
		ReadTestDataFile reader = new ReadTestDataFile();
		reader.fromPath(PROPOSALS_FILE_PATH);
		assertFalse(reader.getProposals().isEmpty());
	}
}