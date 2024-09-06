package grupo.terabite.terabite.service;

import grupo.terabite.terabite.dto.externo.HgExternoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HgApiService {

    @Value("${hgbrasil.api.key}")
    private String apiKey;

    private static final String HG_API_URL = "https://api.hgbrasil.com/weather?key=9c8d7cf9&city_name=São+Paulo,SP";
    HgExternoDto HgApiExternaDto;

    public HgExternoDto getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(HG_API_URL, apiKey);
        return restTemplate.getForObject(url, HgExternoDto.class);
    }
}
