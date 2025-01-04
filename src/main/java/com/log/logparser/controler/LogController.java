package com.log.logparser.controler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class LogController {

    private static final Logger logger = LogManager.getLogger(LogController.class);

    @GetMapping("/generate-log")
    public ResponseEntity<FileSystemResource> generateAndDownloadLog() {
        String logFilePath = "logger.log";
        File logFile = new File(logFilePath);

        try (FileWriter writer = new FileWriter(logFile)) {
            logger.info("Generating log file...");
            writer.write("INFO: Sample login entry \n");
            writer.write("DEBUG:  DEBUGGING LOGIN METHOD\n");
            writer.write("ERROR: failed login\n");
            writer.write("INFO: SIMPLE USER ACCESS\n");
            writer.write("DEBUG: CHECKING USER ACCESS\n");
            writer.write("ERROR: UNAUTHORIZED USER \n");
            writer.write("INFO: CHECKING IMPORTANT DOCUMENT\n");
            writer.write("DEBUG: CALLING DOC METHOD\n");
            writer.write("ERROR: IMPORTANT DOCUMENT DELETED\n");
            logger.info("Log file generation complete.");
        } catch (IOException e) {
            logger.error("Error generating log file.", e);
            return ResponseEntity.internalServerError().build();
        }

        FileSystemResource resource = new FileSystemResource(logFile);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=logger.log");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
