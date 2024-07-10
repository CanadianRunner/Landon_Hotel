package edu.wgu.d387_sample_code.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class MessageFetcher {
    private static final Logger LOGGER = Logger.getLogger(MessageFetcher.class.getName());

    public List<String> getWelcomeMessages() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new WelcomeMessageService(new Locale("en", "US"), "en_message"));
        tasks.add(new WelcomeMessageService(new Locale("fr", "FR"), "fr_message"));

        List<Future<String>> results = executor.invokeAll(tasks);

        List<String> messages = new ArrayList<>();
        for (Future<String> result : results) {
            try {
                String message = result.get();
                LOGGER.info("Fetched message: " + message);
                messages.add(message);
            } catch (ExecutionException | InterruptedException e) {
                LOGGER.severe("Error fetching message: " + e.getMessage());
                throw e;
            }
        }
        executor.shutdown();
        return messages;
    }
}
