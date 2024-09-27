package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Perda;
import grupo.terabite.terabite.service.PerdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perdas")
public class PerdaController {

    @Autowired
    private PerdaService service;

    @GetMapping
    public ResponseEntity<List<Perda>> listarPerda() {
        return ResponseEntity.ok(service.listarPerda());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perda> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(perdaService.buscarPerdaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Perda> criarPerda(@RequestBody Perda novoPerda) {
        return ResponseEntity.status(201).body(perdaService.criarPerda(novoPerda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perda> atualizarPerda(@PathVariable Integer id, @RequestBody Perda atualizarPerda) {
        return ResponseEntity.ok(perdaService.atualizarPerda(id, atualizarPerda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Perda> deletarPerda(@PathVariable Integer id) {
        perdaService.deletarPerda(id);
        return ResponseEntity.noContent().build();
    }
}
