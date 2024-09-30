package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Tipo;
import grupo.terabite.terabite.service.TipopService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    public TipopService service;

    @GetMapping
    public ResponseEntity<List<Tipo>> listarTipos(){
        return ResponseEntity.ok(service.listarTipo());
    }

    @PostMapping
    public ResponseEntity<Tipo> criarTipo(@PathVariable Tipo novoTipo){
        return ResponseEntity.ok(service.criarTipo(novoTipo));
    }
}
