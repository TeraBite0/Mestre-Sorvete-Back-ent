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
@Table(name = "SUBTIPO")
public class Subtipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUBT")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_ID_TIPO_PAI", referencedColumnName = "ID_TIPO")
    private Tipo tipoPai;

    @ManyToOne
    @JoinColumn(name = "FK_ID_TIPO_FILHO", referencedColumnName = "ID_TIPO")
    private Tipo tipoFilho;
}
