package grupo.terabite.terabite.dto.response;

import grupo.terabite.terabite.entity.Produto;
import grupo.terabite.terabite.entity.Venda;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendaProdutoResponseDTO {

    private Integer id;
    private Venda venda;
    private Produto produto;
}
