// package com.bob.project4.authentication;

// import java.util.Date;
// import java.util.UUID;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
// import javax.persistence.Table;

// import com.bob.project4.profile.UserEntity;

// @Entity
// @Table(name = "tokens")
// public class authEntity {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id")
// private int id;

// private String token;

// @Column(name = "created_date")
// private Date createdDate;

// @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
// @JoinColumn(nullable = false, name = "user_id")
// private UserEntity user;

// public authEntity(UserEntity user) {
// this.user = user;
// this.createdDate = new Date();
// this.token = UUID.randomUUID().toString();
// }

// public authEntity() {

// }
// }
