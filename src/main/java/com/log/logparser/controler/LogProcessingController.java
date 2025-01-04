package com.log.logparser.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/process-logs")
public class LogProcessingController {

    @PostMapping
    public ResponseEntity<?> processLogs(@RequestBody List<Map<String, String>> logs) {
        List<Map<String, String>> errorLogs = new ArrayList<>();

        for (Map<String, String> log : logs) {
            String logEntry = log.get("log");
            if (logEntry != null && logEntry.toLowerCase().contains("error")) {
                // Extract timestamp and message
                String[] parts = logEntry.split(" ", 2); // Assuming the first part is the timestamp
                String timestamp = parts.length > 1 ? parts[0] : "Unknown";
                String message = parts.length > 1 ? parts[1] : logEntry;

                errorLogs.add(Map.of("timestamp", timestamp, "message", message));
            }
        }

        return ResponseEntity.ok(Map.of("errors", errorLogs));
    }
}

