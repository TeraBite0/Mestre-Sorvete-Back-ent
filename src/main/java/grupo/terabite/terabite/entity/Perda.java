package grupo.terabite.terabite.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PERDA")
public class Perda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERD")
    private Integer id;

    @Column(name = "QTD_PRODUTO_PERD")
    private Integer qtdProduto;

    @Column(name = "DT_PERDA_PERD")
    private LocalDate dataPerda;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_PERD", referencedColumnName = "ID_PROD")
    private Produto produto;

}
