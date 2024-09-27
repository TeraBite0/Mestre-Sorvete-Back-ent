package grupo.terabite.terabite.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import grupo.terabite.terabite.entity.Produto;

import java.time.LocalDate;

public class LoteUpdateDTO {
    @JsonProperty("produto")
    private Produto produto;

    @JsonProperty("dtCompra")
    private LocalDate dtCompra;

    @JsonProperty("dtVencimento")
    private LocalDate dtVencimento;

    @JsonProperty("dtEntrega")
    private LocalDate dtEntrega;

    @JsonProperty("valorLote")
    private Double valorLote;
}
