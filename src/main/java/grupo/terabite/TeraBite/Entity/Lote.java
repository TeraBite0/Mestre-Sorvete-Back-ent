package grupo.terabite.TeraBite.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dtPedido;
    private LocalDateTime dtEntrega;
    private Produto produto;
    private Date dtVencimento;

    private Integer qtdProdutosComprados;
    private Double valorLote;

    public Lote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public LocalDateTime getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(LocalDateTime dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
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
