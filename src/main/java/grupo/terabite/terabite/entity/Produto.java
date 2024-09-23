package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    @Column(name = "IS_ATIVO")
    private Boolean isAtivo = true;

    public Produto() {
    }

    public Produto(Integer id, String nome, Marca marca, Double preco, Boolean isAtivo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.isAtivo = isAtivo;
    }
}