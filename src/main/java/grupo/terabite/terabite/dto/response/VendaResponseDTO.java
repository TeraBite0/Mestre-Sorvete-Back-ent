package grupo.terabite.terabite.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VendaResponseDTO {

    private Integer id;
    private LocalDateTime dataCompra;
}
