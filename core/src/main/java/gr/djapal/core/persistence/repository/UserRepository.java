package gr.djapal.core.persistence.repository;

import gr.djapal.core.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author djapal
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
