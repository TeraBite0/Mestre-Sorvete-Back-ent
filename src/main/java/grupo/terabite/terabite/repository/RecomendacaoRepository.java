package grupo.terabite.terabite.repository;

import grupo.terabite.terabite.entity.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Integer> {
    Recomendacao findByDtRecomendacao(LocalDate dtRecomendacao);
}
