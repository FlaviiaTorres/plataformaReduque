package git.flavia.PlataformaReduque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.PlataformaReduque.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
