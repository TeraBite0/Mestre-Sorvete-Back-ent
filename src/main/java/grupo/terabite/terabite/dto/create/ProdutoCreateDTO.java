package grupo.terabite.terabite.dto.create;

import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.entity.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoCreateDTO {

    private Integer id;
    @NotBlank
    private String nome;

    @NotBlank
    private Tipo tipo;

    @NotBlank
    private Marca marca;

    @NotBlank
    private Double preco;

    @NotNull
    private Integer qtdEstoque;

    @NotBlank
    private Boolean isAtivo = true;
}
