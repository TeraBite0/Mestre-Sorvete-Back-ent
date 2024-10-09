package grupo.terabite.terabite.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoUpdateDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private Double preco;

    @NotBlank
    private Boolean isAtivo;
}
