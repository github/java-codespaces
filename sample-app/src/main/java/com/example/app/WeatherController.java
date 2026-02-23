package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherForecastController weatherForecastController;

    public WeatherController(WeatherForecastController weatherForecastController) {
        this.weatherForecastController = weatherForecastController;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("forecasts", weatherForecastController.getWeatherForecast());
        return "index";
    }
}
