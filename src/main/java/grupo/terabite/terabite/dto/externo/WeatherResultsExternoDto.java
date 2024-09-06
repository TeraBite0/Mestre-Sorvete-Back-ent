package grupo.terabite.terabite.dto.externo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherResultsExternoDto {

    @JsonProperty("date")
    private String date;

    @JsonProperty("time")
    private String time;

    @JsonProperty("description")
    private String description;

    @JsonProperty("currently")
    private String currently;

    @JsonProperty("city")
    private String city;

    @JsonProperty("rain")
    private double rain;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("forecast")
    private List<ForecastExternoDto> forecast;

    // Getters e Setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrently() {
        return currently;
    }

    public void setCurrently(String currently) {
        this.currently = currently;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<ForecastExternoDto> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastExternoDto> forecast) {
        this.forecast = forecast;
    }
}
