package grupo.terabite.terabite.dto.externo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastExternoDto {

    @JsonProperty("date")
    private String date;

    @JsonProperty("weekday")
    private String weekday;

    @JsonProperty("max")
    private int max;

    @JsonProperty("min")
    private int min;

    @JsonProperty("rain_probability")
    private int rainProbability;

    @JsonProperty("description")
    private String description;

    @JsonProperty("condition")
    private String condition;

    // Getters e Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(int rainProbability) {
        this.rainProbability = rainProbability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
