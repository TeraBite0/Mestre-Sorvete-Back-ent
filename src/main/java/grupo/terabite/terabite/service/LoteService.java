package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.*;
import grupo.terabite.terabite.repository.LoteRepository;
import grupo.terabite.terabite.repository.VendaProdutoRepository;
import grupo.terabite.terabite.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    PerdaService perdaService;
    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    private List<Lote> listarLote() {
        List<Lote> lotes = loteRepository.findAll();
        if (lotes.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(204));
        }
        return lotes;
    }

    private Lote buscarPorId(Integer id) {
        Optional<Lote> lotesOpt = loteRepository.findById(id);
        if (lotesOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return lotesOpt.get();
    }

    public Lote criarLote(Lote novoLote) {
        novoLote.setId(null);
        return loteRepository.save(novoLote);
    }

    public Lote atualizarLote(Integer id, Lote lote) {
        if (!loteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        lote.setId(id);
        return loteRepository.save(lote);
    }

    public void deletarLote(Integer id) {
        if (!loteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        loteRepository.deleteById(id);
    }

    public List<EstoqueProduto> estoque() {
        List<Produto> produtos = produtoService.listarProduto();
        List<Lote> lotes = new ArrayList<>();
        List<Perda> perdas = new ArrayList<>();
        List<VendaProduto> vendas = vendaProdutoRepository.findAll();
        List<EstoqueProduto> estoque = new ArrayList<>();

        try{
            lotes = listarLote();
            perdas = perdaService.listarPerda();
        }catch (ResponseStatusException e){
            if(!e.getStatusCode().equals(HttpStatusCode.valueOf(204))){
                throw e;
            }
        }

        for(Produto p: produtos){
            Integer qtdEmEstoque = 0;
            List<Lote> lotesDoProduto = lotes.stream()
                    .filter(lote -> lote.getProduto().getId().equals(p.getId())).toList();
            List<VendaProduto> vendasDoProduto = vendas.stream()
                    .filter(venda -> venda.getProduto().getId().equals(p.getId())).toList();
            List<Perda> perdasDoProduto = perdas.stream()
                    .filter((perda -> perda.getProduto().getId().equals(p.getId()))).toList();

            for(Lote l: lotesDoProduto){qtdEmEstoque += l.getQtdProdutoComprado();}
            for(VendaProduto v: vendasDoProduto){qtdEmEstoque -= v.getQtdProdutosVendido();}
            for(Perda pe: perdasDoProduto){qtdEmEstoque -= pe.getQtdProduto();}

            estoque.add(new EstoqueProduto(
                    p.getId(),
                    p.getNome(),
                    p.getMarca().getNome(),
                    qtdEmEstoque
            ));
        }

        return estoque;
    }
}
