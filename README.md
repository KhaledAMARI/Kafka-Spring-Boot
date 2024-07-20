# This repository contains a minor version of Kafka interaction with spring-boot

# How to Run

1. Make sure you have docker installed.
2. open your terminal in the root directory and run `docker compose up -d`.
3. Run `docker ps` to check if there's a 3 containers up and running:
        - Kafka
        - Kafka-ui
        - Zookeeper

4. open your browser on `localhost:8090` to check if kafka is running properly.
5. Install dependencies and run the application.
6. Open the browser on `localhost:8080/send?message=<exemple message>` and press Enter.
7. Check the application console, you should see the `<exemple message>` printed.


