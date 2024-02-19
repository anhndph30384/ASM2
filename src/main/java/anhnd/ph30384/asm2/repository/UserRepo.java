package anhnd.ph30384.asm2.repository;

import anhnd.ph30384.asm2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {}
