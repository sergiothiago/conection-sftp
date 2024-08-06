package com.connection.sftp.service;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SftpService {

    private static Logger LOG = LoggerFactory.getLogger(SftpService.class);

    @Autowired
    private Session sftpSession;

    public void connectAndPerformOperations() {
        ChannelSftp channelSftp = null;
        try {
            channelSftp = (ChannelSftp) sftpSession.openChannel("sftp");
            channelSftp.connect();
            LOG.trace("Connected to SFTP server successfully!");

            // Example of uploading a file (optional)
            // String localFile = "/path/to/local/file.txt";
            // String remoteDir = "/path/to/remote/dir/";
            // channelSftp.put(localFile, remoteDir);

            // Example of downloading a file (optional)
            // String remoteFile = "/path/to/remote/file.txt";
            // String localDir = "/path/to/local/dir/";
            // channelSftp.get(remoteFile, localDir);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
            }
            if (sftpSession != null && sftpSession.isConnected()) {
                sftpSession.disconnect();
            }
        }
    }
}
