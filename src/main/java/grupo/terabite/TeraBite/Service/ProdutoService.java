package grupo.terabite.TeraBite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import grupo.terabite.TeraBite.Entity.Produto;
import grupo.terabite.TeraBite.Repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId( Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public Produto adicionarProduto(Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        return novoProduto;
    }

    public Produto atualizarProduto( Integer id,  Produto produtoAtualizado) {
        if(produtoRepository.existsById(id)){
            produtoAtualizado.setId(id);
            return produtoRepository.save(produtoAtualizado);
        }
        return null;
//        throw new RuntimeException("Produto com ID " + id + " não encontrado.");
    }

    public Boolean deletarProduto( Integer id) {
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        }
        return !produtoRepository.existsById(id);
    }
}
