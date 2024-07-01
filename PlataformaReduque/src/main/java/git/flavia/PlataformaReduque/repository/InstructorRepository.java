package git.flavia.PlataformaReduque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.PlataformaReduque.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

	Instructor findByName(String nameInstructor);

}
