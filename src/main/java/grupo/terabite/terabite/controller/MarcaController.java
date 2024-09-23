package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.service.MarcaServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaServise marcaServise;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarca() {
        return ResponseEntity.ok(marcaServise.listarMarca());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(marcaServise.buscarMarcaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Marca> criarMarca(@RequestBody Marca novoMarca) {
        return ResponseEntity.status(201).body(marcaServise.criarMarca(novoMarca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Integer id, @RequestBody Marca atualizarMarca) {
        return ResponseEntity.ok(marcaServise.atualizarMarca(id, atualizarMarca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> deletarMarca(@PathVariable Integer id) {
        marcaServise.deletarMarca(id);
        return ResponseEntity.noContent().build();
    }
}
