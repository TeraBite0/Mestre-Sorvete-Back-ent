package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.dto.externo.ForecastExternoDto;
import grupo.terabite.terabite.dto.externo.HgExternoDto;
import grupo.terabite.terabite.dto.externo.WeatherResultsExternoDto;
import grupo.terabite.terabite.service.HgApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hg")
public class hgApiController {

    @Autowired
    private HgApiService weatherService;

    @GetMapping(produces = "application/json")
    public Optional<HgExternoDto> getWeather() {
        return weatherService.buscarCidade();
    }

    @GetMapping("/buscar-climas")
    public Optional<WeatherResultsExternoDto> buscarClimas() {
        return weatherService.buscarClima();
    }

    @GetMapping("/buscar-previsoes")
    public Optional<List<ForecastExternoDto>> buscarPrevisao() {
        return weatherService.buscarPrevisao();
    }

    @GetMapping("/buscar-previsoes-ordenado-max")
    public List buscarPrevisaoOrdenadoMax() {
        return weatherService.ordenarMaximo();
    }
}
