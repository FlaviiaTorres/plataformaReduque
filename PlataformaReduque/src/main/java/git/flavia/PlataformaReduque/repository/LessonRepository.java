package git.flavia.PlataformaReduque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.PlataformaReduque.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
