package com.microservicesdemo.jsousek.repositories;

import com.microservicesdemo.jsousek.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Override
    List<UserModel> findAll();

    Optional<UserModel> findByUsername(String username);

}
