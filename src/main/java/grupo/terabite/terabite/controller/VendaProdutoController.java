package grupo.terabite.terabite.controller;

import grupo.terabite.terabite.entity.VendaProduto;
import grupo.terabite.terabite.service.VendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas-produtos")
public class VendaProdutoController {

    @Autowired
    private VendaProdutoService vendaProdutoService;

    @GetMapping
    public ResponseEntity<List<VendaProduto>> listarVendaProduto() {
        return ResponseEntity.ok(vendaProdutoService.listarVendaProduto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaProduto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(vendaProdutoService.buscarVendaProdutoPorId(id));
    }

    @PostMapping
    public ResponseEntity<VendaProduto> criarVendaProduto(@RequestBody VendaProduto novoVendaProduto) {
        return ResponseEntity.status(201).body(vendaProdutoService.criarVendaProduto(novoVendaProduto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaProduto> atualizarVendaProduto(@PathVariable Integer id, @RequestBody VendaProduto atualizarVendaProduto) {
        return ResponseEntity.ok(vendaProdutoService.atualizarVendaProduto(id, atualizarVendaProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VendaProduto> deletarVendaProduto(@PathVariable Integer id) {
        vendaProdutoService.deletarVendaProduto(id);
        return ResponseEntity.noContent().build();
    }
}
