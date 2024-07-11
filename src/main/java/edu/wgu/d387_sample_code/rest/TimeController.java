package edu.wgu.d387_sample_code.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeController {

    private static final String START_TIME = "09:00AM EST";
    private static final String DATE_TIME_FORMAT = "hh:mma z";
    private static final String[] TIME_ZONES = new String[]{"EST", "MST", "UTC"};
    private final SimpleDateFormat timeFormatter = new SimpleDateFormat(DATE_TIME_FORMAT);

    @GetMapping("/presentation")
    public ResponseEntity<List<String>> getLivePresentationTimes() {
        List<String> presentationTimes = new ArrayList<>();

        try {
            Date date = timeFormatter.parse(START_TIME);

            for (String t : TIME_ZONES) {
                TimeZone tz = TimeZone.getTimeZone(t);
                timeFormatter.setTimeZone(tz);
                String dateOut = timeFormatter.format(date);
                presentationTimes.add(dateOut);
                System.out.printf("Formatted date for timezone %s: %s%n", t, dateOut);
            }

        } catch (ParseException e) {
            System.err.println("Error parsing the start time: " + e.toString());
            presentationTimes.add("Error parsing the start time: " + e.toString());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.toString());
            presentationTimes.add("Unexpected error: " + e.toString());
        }

        return ResponseEntity.ok(presentationTimes);
    }
}
