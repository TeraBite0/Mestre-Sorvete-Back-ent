package grupo.terabite.terabite.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTO")
//schema = "TRB",
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_PROD")
    private Integer id;

    @Column(name = "NOME_PROD")
    private String nome;


    @Column(name = "MARCA_PROD")
    private String marca;

    @Column(name = "PRECO_PROD")
    private Double preco;

    @Column(name = "QDT_ESTOQUE_PROD")
    private Integer qtdEstoque;

    @Column(name = "IS_ATIVO")
    private Boolean isAtivo = true;

    public Produto() {
    }

    public Produto(Integer id, String nome, String marca, Double preco, Boolean isAtivo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.isAtivo = isAtivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }
}
