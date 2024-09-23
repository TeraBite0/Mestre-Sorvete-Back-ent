package grupo.terabite.terabite.repository;

import grupo.terabite.terabite.entity.Admin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    CharSequence findByEmailAndSenha(@NotBlank @Email String email, @NotBlank String senha);
}
