package grupo.terabite.terabite.entity;

import grupo.terabite.terabite.enums.ProdutoEnum;
import grupo.terabite.terabite.enums.SimNaoEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTO")
//schema = "TRB",
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_PROD")
    private Integer id;

    @Column(name = "ITEM_PROD")
    private ProdutoEnum item;

    @Column(name = "MARCA_PROD")
    private String marca;

    @Column(name = "SABOR_PROD")
    private String sabor;

    @Column(name = "PRECO_PROD")
    private Double preco;

    @Column(name = "QAT_ESTOQUE_PROD")
    private Integer qtdEstoque;

    @Column(name = "IS_ATIVO")
    @Enumerated(EnumType.STRING)
    private SimNaoEnum isAtivo = SimNaoEnum.S;

    public Produto() {
    }

    public Produto(Integer id, ProdutoEnum item, String marca, String sabor, Double preco, Integer qtdEstoque, SimNaoEnum isAtivo) {
        this.id = id;
        this.item = item;
        this.marca = marca;
        this.sabor = sabor;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.isAtivo = isAtivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProdutoEnum getItem() {
        return item;
    }

    public void setItem(ProdutoEnum item) {
        this.item = item;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
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

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public SimNaoEnum getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(SimNaoEnum isAtivo) {
        this.isAtivo = isAtivo;
    }
}
