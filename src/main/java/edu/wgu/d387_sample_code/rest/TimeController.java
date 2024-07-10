package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.service.TimeZoneConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private final TimeZoneConverter timeZoneConverter;

    public TimeController() {
        this.timeZoneConverter = new TimeZoneConverter();
    }

    @GetMapping("/presentation-times")
    public String getPresentationTimes() {
        return timeZoneConverter.getPresentationTimes();
    }
}
