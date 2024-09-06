package grupo.terabite.terabite.entity;

import grupo.terabite.terabite.enums.ProdutoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private ProdutoEnum item;
    private String marca;
    private String sabor;
    private Double preco;
    private Integer qtdEstoque;

    public Produto() {
    }

    public Produto(Integer id, ProdutoEnum item, String marca, String sabor, Double preco, Integer qtdEstoque) {
        this.id = id;
        this.item = item;
        this.marca = marca;
        this.sabor = sabor;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
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
}
