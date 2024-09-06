package grupo.terabite.terabite.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dtPedido;
    private LocalDate dtEntrega;
    private LocalDate dtVencimento;
    private Integer qtdProdutosComprados;
    private Double valorLote;
    @ManyToOne
    private Produto produto;

    public Lote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(LocalDate dtPedido) {
        this.dtPedido = dtPedido;
    }

    public LocalDate getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(LocalDate dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Integer getQtdProdutosComprados() {
        return qtdProdutosComprados;
    }

    public void setQtdProdutosComprados(Integer qtdProdutosComprados) {
        this.qtdProdutosComprados = qtdProdutosComprados;
    }

    public Double getValorLote() {
        return valorLote;
    }

    public void setValorLote(Double valorLote) {
        this.valorLote = valorLote;
    }
}
