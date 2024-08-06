package com.connection.sftp.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class SftpConfig {

    @Bean
    public Session sftpSession() throws Exception {
        String sftpHost = "your.sftp.server.com";
        int sftpPort = 22;
        String sftpUser = "your_username";
        String sftpPassword = "your_password";

        JSch jsch = new JSch();
        Session session = jsch.getSession(sftpUser, sftpHost, sftpPort);
        session.setPassword(sftpPassword);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();
        return session;
    }
}
