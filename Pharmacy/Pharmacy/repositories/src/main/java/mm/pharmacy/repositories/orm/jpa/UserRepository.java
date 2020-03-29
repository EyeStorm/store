package mm.pharmacy.repositories.orm.jpa;

import mm.pharmacy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsernameAndAge(String username, int age);
}
