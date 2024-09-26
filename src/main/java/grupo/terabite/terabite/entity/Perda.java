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
@Table(name = "PERDA")
public class Perda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERD")
    private Integer id;

    @Column(name = "QTD_PRODUTO_PERD")
    private Integer qtdProduto;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_PERD", referencedColumnName = "ID_PROD")
    private Produto produto;
}
