package git.flavia.PlataformaReduque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.PlataformaReduque.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
}
