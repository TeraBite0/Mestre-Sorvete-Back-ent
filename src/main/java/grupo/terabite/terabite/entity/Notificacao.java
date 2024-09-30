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
@Table(name = "NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTI")
    private Integer id;

    @Column(name = "EMAIL_NOTI")
    private String email;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_NOTI", referencedColumnName = "ID_PROD")
    private Produto produto;
}
