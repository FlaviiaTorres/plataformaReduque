package git.flavia.PlataformaReduque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.PlataformaReduque.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCourseId(Long courseId); 

}
