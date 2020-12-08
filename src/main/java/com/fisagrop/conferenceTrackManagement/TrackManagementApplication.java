package com.fisagrop.conferenceTrackManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TrackManagementApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(TrackManagementApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TrackManagementApplication.class);
    }
}