package letscode.sarafan.repo;

import letscode.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepo extends JpaRepository<Message, Long> {
}
