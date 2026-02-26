package com.example.app;

import java.time.LocalDate;

public record WeatherForecast(LocalDate date, int temperatureC, String summary) {

    public int temperatureF() {
        return 32 + (int) (temperatureC / 0.5556);
    }
}
