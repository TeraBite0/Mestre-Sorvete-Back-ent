package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTI")
    private Integer id;

    @Column(name = "EMAIL_NOTI")
    @NotBlank
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_NOTI", referencedColumnName = "ID_PROD")
    @NotBlank
    private Produto produto;

    public Notificacao(Integer id, String email, Produto produto) {
        this.id = id;
        this.email = email;
        this.produto = produto;
    }
}
