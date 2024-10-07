package grupo.terabite.terabite.service;

import grupo.terabite.terabite.entity.Produto;
import grupo.terabite.terabite.entity.Recomendacao;
import grupo.terabite.terabite.repository.RecomendacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecomendacaoService {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    RecomendacaoRepository recomendacaoRepository;

    public Produto recomendacaoDoDia() {
        LocalDate hoje = LocalDate.now();
        Recomendacao recomendacaoDoDia = recomendacaoRepository.findByDtRecomendacao(hoje);
        List<Recomendacao> recomendacoes = recomendacaoRepository.findAll();
        Produto produtoDoDia;

        if (recomendacaoDoDia == null) {
            produtoDoDia = gerarRecomendacaoDoDia(recomendacoes);
            recomendacaoDoDia = new Recomendacao(produtoDoDia, hoje);
            recomendacaoRepository.save(recomendacaoDoDia);
            excluirDadosAntigos(recomendacoes);
        }
        return recomendacaoDoDia.getProduto();
    }

    private Produto gerarRecomendacaoDoDia(List<Recomendacao> recomendacoes) {
        if (recomendacoes.isEmpty()) {
            return produtoAleatorio();
        } else {
            Boolean produtoNovo;
            Produto produtoGerado;

            do {
                produtoNovo = true;
                produtoGerado = produtoAleatorio();

                for (Recomendacao r : recomendacoes) {
                    if (r.getProduto().getId().equals(produtoGerado.getId())) {
                        produtoNovo = false;
                    }
                }
            }
            while (!produtoNovo);

            return produtoGerado;
        }
    }

    private Produto produtoAleatorio() {
        List<Produto> produtos = produtoService.listarProduto();
        Double n = (Math.random() * produtos.size());

        return produtos.get(n.intValue());
    }

    private void excluirDadosAntigos(List<Recomendacao> recomendacoes){
        LocalDate hoje = LocalDate.now();
        for(Recomendacao r: recomendacoes){
            if(r.getDtRecomendacao().isBefore(hoje.minusDays(7))){
                recomendacaoRepository.deleteById(r.getId());
            }
        }
    }
}
