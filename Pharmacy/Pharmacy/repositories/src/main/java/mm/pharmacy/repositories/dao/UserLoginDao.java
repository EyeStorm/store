package mm.pharmacy.repositories.dao;

import mm.pharmacy.entities.UserLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDao extends CrudRepository<UserLogin, Long> {

  UserLogin findUserLoginByUserNameAndPassword(String username, String password);
}
