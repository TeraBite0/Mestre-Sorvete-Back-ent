package grupo.terabite.terabite.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoCreateDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeTipo;

    @NotBlank
    private String nomeMarca;

    @NotBlank
    private Double preco;

    @NotNull
    private Integer qtdEstoque;

    @NotBlank
    private Boolean isAtivo;
}
