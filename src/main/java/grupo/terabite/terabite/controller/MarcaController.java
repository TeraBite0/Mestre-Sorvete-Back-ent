package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarca() {
        return ResponseEntity.ok(service.listarMarca());
    }

}
