package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.dto.externo.HgExternoDto;
import grupo.terabite.terabite.service.HgApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/climas")
public class hgApiController {

    @Autowired
    private HgApiService weatherService;

    @GetMapping(produces = "application/json")
    public HgExternoDto getWeather() {
        return weatherService.getWeather();
    }
}
