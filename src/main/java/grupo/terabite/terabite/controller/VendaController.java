package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.Venda;
import grupo.terabite.terabite.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> listarVenda() {
        return ResponseEntity.ok(vendaService.listarVenda());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(vendaService.buscarVendaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda novoVenda) {
        return ResponseEntity.status(201).body(vendaService.criarVenda(novoVenda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Integer id, @RequestBody Venda atualizarVenda) {
        return ResponseEntity.ok(vendaService.atualizarVenda(id, atualizarVenda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Venda> deletarVenda(@PathVariable Integer id) {
        vendaService.deletarVenda(id);
        return ResponseEntity.noContent().build();
    }
}
