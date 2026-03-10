package com.baeldung.ldp.builder;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Calendar;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

class JdkBuilderExamplesUnitTest {

    @Test
    void givenStringBuilder_whenChaining_thenProducesString() {
        String result = new StringBuilder()
                .append("Task: ")
                .append("Design login page")
                .append(" [")
                .append("IN_PROGRESS")
                .append("]")
                .toString();
    }

    @Test
    void givenHttpRequest_whenBuilt_thenReturnsRequest() {
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.example.com/tasks"))
                .header("Accept", "application/json")
                .GET()
                .build();
    }

    @Test
    void givenCalendarBuilder_whenBuilt_thenReturnsCalendar() {
        Calendar calendar = new Calendar.Builder()
                .setDate(2050, Calendar.JUNE, 15)
                .setTimeZone(TimeZone.getDefault())
                .build();
    }
}
