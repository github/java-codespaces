package com.example.app;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherForecastController {

    private static final String[] SUMMARIES = {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild",
        "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    @GetMapping("/weatherforecast")
    public List<WeatherForecast> getWeatherForecast() {
        var random = ThreadLocalRandom.current();
        return IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new WeatherForecast(
                        LocalDate.now().plusDays(i),
                        random.nextInt(-20, 55),
                        SUMMARIES[random.nextInt(SUMMARIES.length)]
                ))
                .toList();
    }
}
