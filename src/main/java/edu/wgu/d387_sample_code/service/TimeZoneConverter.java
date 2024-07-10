package edu.wgu.d387_sample_code.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    public String getPresentationTimes() {
        LocalDateTime now = LocalDateTime.now();

        ZonedDateTime ptTime = now.atZone(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime ctTime = now.atZone(ZoneId.of("America/Chicago"));
        ZonedDateTime utcTime = now.atZone(ZoneId.of("UTC"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String ptFormatted = ptTime.format(formatter) + " PT";
        String ctFormatted = ctTime.format(formatter) + " CT";
        String utcFormatted = utcTime.format(formatter) + " UTC";

        return String.format("Live presentation times: %s, %s, %s", ptFormatted, ctFormatted, utcFormatted);
    }
}
