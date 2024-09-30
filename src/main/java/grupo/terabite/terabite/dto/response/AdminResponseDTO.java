package grupo.terabite.terabite.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminResponseDTO {

    private Integer id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
}
