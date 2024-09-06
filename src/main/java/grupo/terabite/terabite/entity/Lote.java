package grupo.terabite.terabite.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LOTE")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_LOTE")
    private Integer id;

    @Column(name = "DATA_PEDIDO_LOTE")
    private LocalDate dtPedido;

    @Column(name = "DATA_ENTREGA_LOTE")
    private LocalDate dtEntrega;

    @Column(name = "DATA_VENCIMENTO_LOTE")
    private LocalDate dtVencimento;

    @Column(name = "QTD_PRODUTO_COMPRADO_LOTE")
    private Integer qtdProdutoComprado;

    @Column(name = "VALOR_LOTE")
    private Double valorLote;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_LOTE", referencedColumnName = "ID_PROD")
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

    public Integer getQtdProdutoComprado() {
        return qtdProdutoComprado;
    }

    public void setQtdProdutoComprado(Integer qtdProdutoComprado) {
        this.qtdProdutoComprado = qtdProdutoComprado;
    }

    public Double getValorLote() {
        return valorLote;
    }

    public void setValorLote(Double valorLote) {
        this.valorLote = valorLote;
    }
}
