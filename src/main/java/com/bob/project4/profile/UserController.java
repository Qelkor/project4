package com.bob.project4.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
  @Autowired
  UserRepository userRepo;

  // Get Route
  @GetMapping("/users")
  public ResponseEntity<List<UserEntity>> getAllUsers(@RequestParam(required = false) String name) {
    try {
      List<UserEntity> users = new ArrayList<UserEntity>();
      if (name == null)
        userRepo.findAll().forEach(users::add);
      else
        userRepo.findByName(name).forEach(users::add);

      if (users.isEmpty()) {
        return new ResponseEntity<>(users, HttpStatus.OK);
      }
      return new ResponseEntity<>(users, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Get by ID
  @GetMapping("/users/{id}")
  public ResponseEntity<UserEntity> getUserById(@PathVariable("id") int id) {
    Optional<UserEntity> userData = userRepo.findById(id);

    if (userData.isPresent()) {
      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Get Data login
  @PostMapping("/users/login")
  public ResponseEntity<UserEntity> loginUser(@RequestBody UserEntity user) {
    UserEntity userCheck = userRepo.findByEmail(user.email);

    if (password.equalsIgnoreCase(userCheck.getPassword()) && email.equalsIgnoreCase(userCheck.getEmail())) {
      return new ResponseEntity<>(userCheck, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
    }
  }

  // Post Data
  @PostMapping("/users")
  public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
    try {
      UserEntity _user = userRepo
          .save(
              new UserEntity(user.getName(), user.getEmail(), user.getPassword(), user.getAddress()));
      return new ResponseEntity<>(_user, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Update Data
  @PutMapping("/users/{id}")
  public ResponseEntity<UserEntity> updateUser(@PathVariable("id") int id, @RequestBody UserEntity user) {
    Optional<UserEntity> userData = userRepo.findById(id);

    if (userData.isPresent()) {
      UserEntity _user = userData.get();
      _user.setName(user.getName());
      _user.setEmail(user.getEmail());
      _user.setPassword(user.getPassword());
      _user.setAddress(user.getAddress());
      return new ResponseEntity<>(userRepo.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Delete Data
  @DeleteMapping("/users/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
    try {
      userRepo.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
