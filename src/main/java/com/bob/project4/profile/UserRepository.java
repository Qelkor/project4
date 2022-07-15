package com.bob.project4.profile;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  List<UserEntity> findByName(String name);

  UserEntity findByEmail(String email);

  List<UserEntity> findByPassword(String password);

}
