package grupo.terabite.terabite.entity;


// ESta classe não representa uma entidade do banco, mas sim um conjunto de outros dados processados de outras tabelas

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
public class EstoqueProduto {

    private Integer codigo; // Produto id

    private String produto; // Nome do produto

    private String marca; // Marca do produto

    private Integer qtdEstoque; // Calculo da qtd de produtos (em lotes - vendidos - perdas)
    }
