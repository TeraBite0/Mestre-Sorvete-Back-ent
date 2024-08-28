package grupo.terabite.TeraBite.Controller;

import grupo.terabite.TeraBite.Entity.Produto;
import grupo.terabite.TeraBite.Repository.ProdutoRepository;
import grupo.terabite.TeraBite.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return service.adicionarProduto(produto);
    }


    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        return service.atualizarProduto(id, produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        service.deletarProduto(id);
    }
}
