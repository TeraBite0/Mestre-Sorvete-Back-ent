package grupo.terabite.terabite.dto.mapper;

import grupo.terabite.terabite.dto.create.PerdaCreateDTO;
import grupo.terabite.terabite.dto.response.PerdaResponseDTO;
import grupo.terabite.terabite.entity.Perda;
import grupo.terabite.terabite.entity.Produto;

public class PerdaMapper {

    public static PerdaResponseDTO toResponsePerda(Perda perda){
        if(perda == null) return null;

        Produto produto = perda.getProduto();

        return PerdaResponseDTO.builder()
                .id(perda.getId())
                .produto(ProdutoMapper.toDetalhe(produto))
                .qtdProduto(perda.getQtdProduto())
                .build();
    }

    public static Perda toCrearPerda(PerdaCreateDTO perda){
        if(perda == null) return null;

        return Perda.builder()
                .qtdProduto(perda.getQtdPerda())
                .build();
    }
}
