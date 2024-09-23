package grupo.terabite.terabite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    public Admin() {
    }

    public Admin(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }
}