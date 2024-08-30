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
    LoteService service;

    @GetMapping
    public ResponseEntity<List<Lote>> listarLote(){
        return service.listarLote();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Lote> adicionarLote(@RequestBody Lote novoLote){
        return service.adicionarLote(novoLote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> atualizarLote(@PathVariable Integer id, @RequestBody Lote loteAtualizado){
        return service.atualizarLote(id, loteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLote(@PathVariable Integer id){
        return service.deletarLote(id);
    }
}
