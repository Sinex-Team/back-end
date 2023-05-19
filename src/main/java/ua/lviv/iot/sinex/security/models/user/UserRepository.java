package ua.lviv.iot.sinex.security.models.user;

import java.util.Optional;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
