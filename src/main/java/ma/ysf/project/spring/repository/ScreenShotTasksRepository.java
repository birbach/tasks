package ma.ysf.project.spring.repository;

import ma.ysf.project.spring.model.ScreenShotTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenShotTasksRepository extends JpaRepository<ScreenShotTasks,Long> {
}
