package git.flavia.PlataformaReduque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.PlataformaReduque.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	 List<Course> findByInstructorId(Long instructorId);

}
