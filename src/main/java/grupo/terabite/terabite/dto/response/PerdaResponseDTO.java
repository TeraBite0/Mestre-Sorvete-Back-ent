package grupo.terabite.terabite.dto.response;

import grupo.terabite.terabite.entity.Produto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerdaResponseDTO {

    private Integer id;
    private ProdutoResponseDTO produto;
    private Integer qtdProduto;
}
