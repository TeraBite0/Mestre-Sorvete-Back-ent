package grupo.terabite.terabite.repository;

import grupo.terabite.terabite.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    Marca findByNomeIgnoreCase(String nomeMarca);
}
