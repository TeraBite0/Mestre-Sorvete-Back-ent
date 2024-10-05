package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VENDAS_PRODUTO")
public class VendaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENP")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_ID_VEND_VENP", referencedColumnName = "ID_VEND")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_VENP", referencedColumnName = "ID_PROD")
    private Produto produto;

    @Column(name = "QTD_PRODUTOS_VENDIDO")
    private Integer qtdProdutosVendido;
}
