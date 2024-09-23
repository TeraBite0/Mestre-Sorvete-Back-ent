package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.VendaProduto;
import grupo.terabite.terabite.repository.VendaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VendaProdutoService {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    public List<VendaProduto> listarVendaProduto(){
        List<VendaProduto> vendaProdutos = vendaProdutoRepository.findAll();
        if(vendaProdutos.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return vendaProdutos;
    }

    public VendaProduto buscarVendaProdutoPorId(Integer id){
        Optional<VendaProduto> vendaProdutosOpt = vendaProdutoRepository.findById(id);
        if(vendaProdutosOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return vendaProdutosOpt.get();
    }

    public VendaProduto criarVendaProduto(VendaProduto novaVendaProduto){
        novaVendaProduto.setId(null);
        return vendaProdutoRepository.save(novaVendaProduto);
    }

    public VendaProduto atualizarVendaProduto(Integer id, VendaProduto atualizarVendaProduto){
        if(!vendaProdutoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        atualizarVendaProduto.setId(null);
        return vendaProdutoRepository.save(atualizarVendaProduto);
    }

    public void deletarVendaProduto(Integer id){
        if(!vendaProdutoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        vendaProdutoRepository.deleteById(id);
    }
}
