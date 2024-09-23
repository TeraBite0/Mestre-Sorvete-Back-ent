package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Lote;
import grupo.terabite.terabite.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    @Autowired
    private LoteService service;

    @GetMapping
    public ResponseEntity<List<Lote>> listarLote() {
        return ResponseEntity.ok(service.listarLote());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Lote> adicionarLote(@RequestBody Lote novoLote) {
        return ResponseEntity.ok(service.criarLote(novoLote));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> atualizarLote(@PathVariable Integer id, @RequestBody Lote loteAtualizado) {
        return ResponseEntity.ok(service.atualizarLote(id, loteAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lote> deletarLote(@PathVariable Integer id) {
        service.deletarLote(id);
        return ResponseEntity.noContent().build();
    }
}