package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ADMIN")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ADMIN")
    private Integer id;

    @Column(name = "EMAIL_ADMIN")
    private String email;

    @Column(name = "SENHA_ADMIN")
    private String senha;
}