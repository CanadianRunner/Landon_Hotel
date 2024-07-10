package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.service.MessageFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class WelcomeController {
    private final MessageFetcher messageFetcher;

    public WelcomeController() {
        this.messageFetcher = new MessageFetcher();
    }

    @GetMapping("/welcome")
    public List<String> getWelcomeMessages() throws InterruptedException, ExecutionException {
        return messageFetcher.getWelcomeMessages();
    }
}