package grupo.terabite.terabite.service;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import grupo.terabite.terabite.entity.Produto;
import grupo.terabite.terabite.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<List<Produto>> listarProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtos);
    }

    public ResponseEntity<Produto> buscarPorId( Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produto.orElse(null));
    }

    public ResponseEntity<Produto> adicionarProduto(Produto novoProduto) {
        novoProduto.setId(null);
        return ResponseEntity.status(201).body(produtoRepository.save(novoProduto));
    }

    public ResponseEntity<Produto> atualizarProduto( Integer id,  Produto produtoAtualizado) {
        if(!produtoRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        produtoAtualizado.setId(id);
        return ResponseEntity.status(200).body(produtoRepository.save(produtoAtualizado));
    }

    public ResponseEntity<Void> deletarProduto( Integer id) {
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
