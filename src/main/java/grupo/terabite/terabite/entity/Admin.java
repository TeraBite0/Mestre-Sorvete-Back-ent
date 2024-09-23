package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADMIN")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ADMIN")
    Integer id;

    @NotBlank
    @Email
    @Column(name = "EMAIL_ADMIN")
    String email;

    @NotBlank
    @Column(name = "SENHA_ADMIN")
    String senha;
}