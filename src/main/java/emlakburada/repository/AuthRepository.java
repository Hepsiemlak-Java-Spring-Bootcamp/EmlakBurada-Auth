package emlakburada.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import emlakburada.entity.User;

public interface AuthRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}
