package mm.pharmacy.services.impl;

import mm.pharmacy.entities.User;
import mm.pharmacy.entities.UserLogin;
import mm.pharmacy.models.LoginModel;
import mm.pharmacy.models.UserLoginModel;
import mm.pharmacy.repositories.dao.UserLoginDao;
import mm.pharmacy.repositories.orm.jpa.UserRepository;
import mm.pharmacy.repositories.orm.mybatis.UserMapper;
import mm.pharmacy.services.api.IUserService;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper userMapper;


  @Autowired
  private UserLoginDao userDao;

  @Override
  public UserLoginModel getUser(LoginModel loginModel) {
    UserLoginModel model = new UserLoginModel();
    UserLogin user = userDao.findUserLoginByUserNameAndPassword(loginModel.getUserName(), loginModel.getPassword());
    if (user != null) {
      model.setEmail(user.getEmail());
      model.setFirstName(user.getFirstName());
      model.setId(user.getId());
      model.setLastName(user.getLastName());
      model.setMobile(user.getPassword());
      model.setPassword(user.getPassword());
      model.setUserName(user.getUserName());
    }
    return model;
  }
	
	/*public List<UserLogin> getAllUsers() {
		List<UserLogin> persons = (List<UserLogin>) userDao.findAll();
		return persons;
	}

	public void save(UserLogin person) {
		userDao.save(person);
	}*/
  @Override
  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  @Transactional(readOnly = true)
  public User findById(Long id) {
    return userMapper.selectByUserId(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> findAll() {
    return userMapper.selectAllUser();
  }
}
