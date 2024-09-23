package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROD")
    private Integer id;

    @NotBlank
    @Column(name = "NOME_PROD")
    private String nome;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "FK_ID_MARCA_PROD", referencedColumnName = "ID_MARCA")
    private Marca marca;

    @NotBlank
    @Column(name = "PRECO_PROD")
    private Double preco;

    @NotNull
    @Column(name = "QDT_ESTOQUE_PROD")
    private Integer qtdEstoque;

    @NotBlank
    @Column(name = "IS_ATIVO_PROD")
    private Boolean isAtivo = true;
}