package grupo.terabite.terabite.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import grupo.terabite.terabite.entity.Marca;
import grupo.terabite.terabite.entity.Tipo;

public class ProdutoResponseDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("tipo")
    private Tipo tipo;

    @JsonProperty("marca")
    private Marca marca;

    @JsonProperty("preco")
    private Double preco;

    @JsonProperty("img")
    private String img;

    @JsonProperty("ativo")
    private Boolean ativo;
}
