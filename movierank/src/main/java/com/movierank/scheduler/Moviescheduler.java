package com.movierank.scheduler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.movierank.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Moviescheduler {
	
	@Autowired
	MovieService mService;
	
	@Scheduled(cron = "0 14 11 * * *")
	public void movieConllect() throws IOException {
		log.info(">>>>> Movie ticjetrank Collect");
		mService.ticketRank();
	}

}
