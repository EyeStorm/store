package com.tiagohs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiagohs.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT COUNT(u) FROM User u")
  Long getTotalUsers();

  @Query("SELECT u FROM User u where u.isLogin = 1")
  User finUserSignIn();

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("UPDATE User SET isLogin = 1 where email =:email and password = :password")
  void setUserAsSignIn(@Param("email") String email, @Param("password") String password);

  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("UPDATE User SET isLogin = 0 where isLogin = 1")
  void setUserAsSignOut();

  User findByEmail(String email);

  User findByEmailAndPassword(String email, String password);


}
