package grupo.terabite.terabite.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminCreateDTO {

    @NotBlank
    @Email
    @Schema(description = "Email do usuário")
    private String email;
    @NotBlank
    @Size(min = 8, max = 16)
    @Schema(description = "Senha do usuário")
    private String senha;
}
