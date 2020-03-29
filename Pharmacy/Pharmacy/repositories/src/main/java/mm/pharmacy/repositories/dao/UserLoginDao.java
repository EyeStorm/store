package mm.pharmacy.repositories.dao;

import mm.pharmacy.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Long> {

  UserLogin findUserLoginByUserNameAndPassword(String username, String password);
}
