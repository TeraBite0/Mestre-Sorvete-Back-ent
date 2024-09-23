package grupo.terabite.terabite.repository;

import grupo.terabite.terabite.entity.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Integer> {
}
