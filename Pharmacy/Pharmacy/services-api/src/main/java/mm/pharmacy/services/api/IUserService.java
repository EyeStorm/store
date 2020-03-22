package mm.pharmacy.services.api;


import mm.pharmacy.entities.User;
import mm.pharmacy.models.LoginModel;
import mm.pharmacy.models.UserLoginModel;

import java.util.List;

public interface IUserService {

	/*public List<UserLogin> getAllUsers();
	
	public void save(UserLogin person);*/

  UserLoginModel getUser(LoginModel loginModel);

  User save(User user);

  User findById(Long id);

  List<User> findAll();
}
