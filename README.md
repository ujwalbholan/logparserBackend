# log parser backend
## Overview
log parser is a basic log parsing and alerting system designed to process log files from security systems like SIEM (Security Information and Event Management) or other tools. It scans log files for specific patterns, such as error messages or suspicious activities, and generates alerts when such patterns are detected.

In this project, I have implemented both the frontend and backend components to achieve a seamless log parser and alart system. The frontend provides a user-friendly interface with a button to generate a logger.log file. Upon clicking the button, the log file is automatically downloaded to the user's local machine.

Additionally, the interface allows users to upload the generated log file back into the system. Once the file is uploaded, the application processes it to identify and extract error logs, displaying them as the output. This streamlined process ensures efficient log generation, analysis, and error detection, making it a practical tool for log management.

This project demonstrates my ability to handle both frontend and backend development. The frontend, built using React, is deployed on Vercel, while the backend, developed with Java Spring Boot, is hosted on Render. This setup highlights my skills in creating a full-stack application and managing deployment across different platforms.

[visit the page](https://log-parser-frontend.vercel.app/)
## The whole process of system
When the user clicks the Generate Log button, a request is sent to the backend, where the generate-log controller handles the request. This controller processes the request and creates a logger.log file, which is then downloaded to the user's local machine.

Afterward, the user can upload the generated log file back to the system and click the Analyze button. This triggers a request to the backend, directed to the process-log controller. The controller processes the uploaded log file, identifies error logs, and sends the results back to the frontend. The frontend then displays the extracted error logs in a user-friendly format.
