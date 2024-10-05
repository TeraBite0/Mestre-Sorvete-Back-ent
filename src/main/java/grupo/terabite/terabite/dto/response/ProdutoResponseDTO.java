package grupo.terabite.terabite.dto.response;

import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.entity.Tipo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.stream.DoubleStream;

@Data
@Builder
public class ProdutoResponseDTO {

    private Integer id;
    @NotBlank
    private String nome;

    @NotBlank
    private Double preco;

    @NotNull
    private Integer qtdEstoque;

    @NotBlank
    private Boolean isAtivo = true;

    @NotBlank
    private TipoResponseDTO tipo;

    @NotBlank
    private MarcaResponseDTO marca;
}
