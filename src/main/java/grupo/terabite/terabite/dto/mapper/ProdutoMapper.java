package grupo.terabite.terabite.dto.mapper;

import grupo.terabite.terabite.dto.create.ProdutoCreateDTO;
import grupo.terabite.terabite.dto.response.MarcaResponseDTO;
import grupo.terabite.terabite.dto.response.ProdutoResponseDTO;
import grupo.terabite.terabite.dto.response.TipoResponseDTO;
import grupo.terabite.terabite.dto.update.ProdutoUpdateDTO;
import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.entity.Produto;
import grupo.terabite.terabite.entity.Tipo;

import java.util.stream.DoubleStream;

public class ProdutoMapper {

    public static ProdutoResponseDTO toDetalhe(Produto produto){
        if(produto == null) return null;

        Marca marca = produto.getMarca();
        Tipo tipo = produto.getTipo();

        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .isAtivo(produto.getIsAtivo())
                .qtdEstoque(produto.getQtdEstoque())
                .marca(MarcaResponseDTO.builder()
                        .id(marca.getId())
                        .nome(marca.getNome())
                        .build())
                .tipo(TipoResponseDTO.builder()
                        .id(tipo.getId())
                        .nome(tipo.getNome())
                        .build())
                .build();
    }

    public static Produto toCriarProduto(ProdutoCreateDTO entity){
        if(entity == null) return null;

        return Produto.builder()
                .nome(entity.getNome())
                .preco(entity.getPreco())
                .qtdEstoque(entity.getQtdEstoque())
                .isAtivo(entity.getIsAtivo())
                .build();
    }

    public static Produto toAtualizar(ProdutoUpdateDTO entity){
        if(entity == null) return null;

        return Produto.builder()
                .nome(entity.getNome())
                .preco(entity.getPreco())
                .qtdEstoque(entity.getQtdEstoque())
                .isAtivo(entity.getIsAtivo())
                .build();
    }
}
