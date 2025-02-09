package com.adriandlph.tasksmsrv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author adriandlph
 *
 */
@SpringBootApplication
public class TasksMsrv {
	private static final Logger LOG = LoggerFactory.getLogger(TasksMsrv.class);
	
	public static void main(String[] args) {
		LOG.info("Starting TasksMsrv...");
		SpringApplication.run(TasksMsrv.class, args);
	}
}
