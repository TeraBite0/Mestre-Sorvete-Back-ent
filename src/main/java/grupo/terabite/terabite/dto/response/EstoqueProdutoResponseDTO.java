package grupo.terabite.terabite.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstoqueProdutoResponseDTO {
    @NotNull
    private Integer codigo;

    @NotNull
    private String produto;

    @NotNull
    private String marca;

    @NotNull
    private Integer qtdEstoque;
}
