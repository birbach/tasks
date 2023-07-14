package ma.ysf.project.spring.repository;

import ma.ysf.project.spring.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long> {
}
