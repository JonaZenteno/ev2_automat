package com.simple_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_form.model.UsersModel;
import com.simple_form.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String login, String password, String mail) {
        if (login == null && password == null) {
            return null;
        } else {
            UsersModel userModel = new UsersModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setMail(mail);
            return usersRepository.save(userModel);

        }

    }
 //implementamos el método de autenticación para nuestro servicio
    public UsersModel authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
