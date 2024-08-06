package com.connection.sftp.controller;

import com.connection.sftp.service.SftpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author sergiothiago
 * Simple connection to a sftp server, using spring.
 */
@RestController
@RequestMapping("/v1/connection")
public class SftpController {

	private static Logger LOG = LoggerFactory.getLogger(SftpController.class);

	@Autowired
	private SftpService sftpService;

	@GetMapping("/sftp")
	public ResponseEntity<String> connectionSFTP() {
		LOG.trace("Sftp Connection - Try to connect");

		sftpService.connectAndPerformOperations();

		LOG.trace("Sftp Connection - Connected successfully");
		return ResponseEntity.ok("SFTP operation completed!");
	}

}
