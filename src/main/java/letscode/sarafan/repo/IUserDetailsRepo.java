package letscode.sarafan.repo;

import letscode.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDetailsRepo extends JpaRepository<User, String> {
}
