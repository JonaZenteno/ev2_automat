package com.simple_form.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple_form.model.UsersModel;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    Optional<UsersModel> findByLoginAndPassword(String login, String password);

}
