package ma.ysf.project.spring.repository;

import ma.ysf.project.spring.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepository extends JpaRepository<Statut,Long> {

    Statut findByCode(String code);
}
