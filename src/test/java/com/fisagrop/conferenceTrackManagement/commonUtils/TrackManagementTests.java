package com.fisagrop.conferenceTrackManagement.commonUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fisagrop.conferenceTrackManagement.service.TrackManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TrackManagementTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	private static final String PROPOSALS_FILE_PATH = 	"src"
														.concat(File.separator)
														.concat("test")
														.concat(File.separator)
														.concat("data")
														.concat(File.separator)
														.concat("proposalsFile.txt");
	
	private static ReadTestDataFile reader = new ReadTestDataFile();
	private List<String> proposals;
	
	private TrackManagement trackManagement;
	
	@BeforeEach
	public void beforeAll() {
		reader.fromPath(PROPOSALS_FILE_PATH);
		this.proposals = reader.getProposals();
	}
	
	@AfterEach
	public void afterAll() {
		this.proposals = null;
		this.trackManagement = null;
	}
	
	@Test
	public void testReadingFileWithExistInputPath() {
		assertFalse(this.proposals.isEmpty());
	}
	
	@Test
	public void testCreatedTruckManagement() {
		this.givenTruckManagementWithProposals();
		System.out.println(this.trackManagement.getTrucks());
		assertNotNull(this.trackManagement);
		assertNotNull(this.trackManagement.getTrucks());
		assertFalse(this.trackManagement.getTrucks().isEmpty());
	}
	
	private void givenTruckManagementWithProposals() {
		this.trackManagement = new TrackManagement(this.proposals);
	}
}