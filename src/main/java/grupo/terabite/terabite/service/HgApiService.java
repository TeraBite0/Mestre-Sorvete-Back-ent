package grupo.terabite.terabite.service;

import grupo.terabite.terabite.dto.externo.ForecastExternoDto;
import grupo.terabite.terabite.dto.externo.HgExternoDto;
import grupo.terabite.terabite.dto.externo.WeatherResultsExternoDto;
import grupo.terabite.terabite.generico.IOrdenadorGenerico;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HgApiService implements IOrdenadorGenerico{

    public Optional<HgExternoDto> buscarCidade() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://api.hgbrasil.com/weather?key=9c8d7cf9&city_name=São+Paulo,SP", "${hgbrasil.api.key}");
        HgExternoDto list = restTemplate.getForObject(url, HgExternoDto.class);
        return Optional.ofNullable(list);
    }

    public Optional<WeatherResultsExternoDto> buscarClima(){
        return buscarCidade().map(HgExternoDto::getResults);
    }

    public Optional<List<ForecastExternoDto>> buscarPrevisao(){
        return buscarClima().map(WeatherResultsExternoDto::getForecast);
    }

    @Override
    public List ordenarMaximo() {
        List<ForecastExternoDto> list = buscarPrevisao().get();
        for (int i = 1; i < list.size(); ++i) {
            ForecastExternoDto key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).getMax() < key.getMax())) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        return list;
    }
}
