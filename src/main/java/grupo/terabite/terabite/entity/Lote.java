package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOTE")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOTE")
    private Integer id;

    @Column(name = "DATA_PEDIDO_LOTE")
    @NotNull
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
}
