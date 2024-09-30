package grupo.terabite.terabite.dto.mapper;

import grupo.terabite.terabite.dto.create.ProdutoCreateDTO;
import grupo.terabite.terabite.dto.response.ProdutoResponseDTO;
import grupo.terabite.terabite.entity.Produto;

public class ProdutoMapper {

    public static ProdutoCreateDTO toCriarProduto(Produto entity){
        if(entity == null) return null;

        return ProdutoCreateDTO.builder()
                .id(entity.getId())
                .tipo(entity.getTipo())
                .nome(entity.getNome())
                .marca(entity.getMarca())
                .preco(entity.getPreco())
                .isAtivo(entity.getIsAtivo())
                .qtdEstoque(entity.getQtdEstoque())
                .build();
    }
}
