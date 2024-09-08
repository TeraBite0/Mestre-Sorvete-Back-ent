package grupo.terabite.terabite.repository;

import grupo.terabite.terabite.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmailAndSenha(String email,String senha);
}
