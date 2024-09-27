package grupo.terabite.terabite.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HgExternalDTO {

    @JsonProperty("by")
    private String by;

    @JsonProperty("valid_key")
    private boolean validKey;

    @JsonProperty("results")
    private WeatherResultsExternalDTO results;

    @JsonProperty("execution_time")
    private float executionTime;

    @JsonProperty("from_cache")
    private boolean fromCache;

    // Getters e Setters
    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public boolean isValidKey() {
        return validKey;
    }

    public void setValidKey(boolean validKey) {
        this.validKey = validKey;
    }

    public WeatherResultsExternalDTO getResults() {
        return results;
    }

    public void setResults(WeatherResultsExternalDTO results) {
        this.results = results;
    }

    public float getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(float executionTime) {
        this.executionTime = executionTime;
    }

    public boolean isFromCache() {
        return fromCache;
    }

    public void setFromCache(boolean fromCache) {
        this.fromCache = fromCache;
    }
}
