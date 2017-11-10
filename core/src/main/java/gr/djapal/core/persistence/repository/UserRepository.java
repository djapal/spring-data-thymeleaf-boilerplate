package gr.djapal.core.persistence.repository;

import gr.djapal.core.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
