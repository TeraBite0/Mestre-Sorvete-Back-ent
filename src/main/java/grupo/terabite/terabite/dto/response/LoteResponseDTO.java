package grupo.terabite.terabite.dto.response;

import grupo.terabite.terabite.entity.Produto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LoteResponseDTO {

    private Integer id;
    @NotNull
    private LocalDate dtPedido;
    private LocalDate dtEntrega;
    private LocalDate dtVencimento;
    @NotNull
    private Integer qtdProdutoComprado;
    @NotNull
    private Double valorLote;
    @NotNull
    private Produto produto;
}
