package grupo.terabite.terabite.dto.create;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerdaCreateDTO {

    private String nome;
    private Integer qtdPerda;
}
