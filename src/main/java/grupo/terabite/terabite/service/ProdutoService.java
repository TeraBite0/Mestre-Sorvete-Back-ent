package grupo.terabite.terabite.service;

import grupo.terabite.terabite.dto.create.ProdutoCreateDTO;
import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.entity.Produto;
import grupo.terabite.terabite.entity.Tipo;
import grupo.terabite.terabite.repository.MarcaRepository;
import grupo.terabite.terabite.repository.ProdutoRepository;
import grupo.terabite.terabite.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

        @Autowired
        private ProdutoRepository produtoRepository;

        @Autowired
        private MarcaRepository marcaRepository;

        @Autowired
        private TipoRepository tipoRepository;

        public ProdutoCreateDTO criarProduto(ProdutoCreateDTO produtoDTO) {
            // Verifica se a Marca já existe
            Marca marca = marcaRepository.findById(produtoDTO.getMarca().getId())
                    .orElseGet(() -> {
                        // Caso não exista, cria uma nova marca
                        Marca novaMarca = new Marca();
                        novaMarca.setNome(produtoDTO.getMarca().getNome());
                        return marcaRepository.save(novaMarca);
                    });

            // Verifica se o Tipo já existe
            Tipo tipo = tipoRepository.findById(produtoDTO.getTipo().getId())
                    .orElseGet(() -> {
                        // Caso não exista, cria um novo tipo
                        Tipo novoTipo = new Tipo();
                        novoTipo.setNome(produtoDTO.getTipo().getNome());
                        return tipoRepository.save(novoTipo);
                    });

            // Agora que Marca e Tipo estão garantidos, pode-se criar o Produto
            Produto produto = new Produto();
            produto.setNome(produtoDTO.getNome());
            produto.setTipo(tipo);
            produto.setMarca(marca);
            produto.setPreco(produtoDTO.getPreco());
            produto.setQtdEstoque(produtoDTO.getQtdEstoque());
            produto.setIsAtivo(produtoDTO.getIsAtivo());

            // Salva o produto
            Produto produtoSalvo = produtoRepository.save(produto);

            return ProdutoCreateDTO.builder()
                    .id(produtoSalvo.getId())
                    .nome(produtoSalvo.getNome())
                    .tipo(produtoSalvo.getTipo())
                    .marca(produtoSalvo.getMarca())
                    .preco(produtoSalvo.getPreco())
                    .qtdEstoque(produtoSalvo.getQtdEstoque())
                    .isAtivo(produtoSalvo.getIsAtivo())
                    .build();
        }


    public List<Produto> listarProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return produtos;
    }

    public Produto buscarPorId(Integer id) {
        Optional<Produto> produtosOpt = produtoRepository.findById(id);
        if (produtosOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return produtosOpt.get();
    }
    }

//
//    public Produto criarProduto(Produto novoProduto) {
//        novoProduto.setId(null);
//        return produtoRepository.save(novoProduto);
//    }
//
//    public Produto atualizarProduto(Integer id, Produto produtoAtualizado) {
//        if (!produtoRepository.existsById(id)) {
//            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
//        }
//        produtoAtualizado.setId(id);
//        return produtoRepository.save(produtoAtualizado);
//    }
//}
