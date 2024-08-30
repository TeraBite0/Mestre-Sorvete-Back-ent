package grupo.terabite.terabite.repository;

import grupo.terabite.terabite.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
