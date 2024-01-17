package com.minimarket.ayni.service;

import com.minimarket.ayni.model.entities.User;
import com.minimarket.ayni.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepositories.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositories.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepositories.save(user);
    }

    @Override
    public Optional<User> update(User user, Long id) {
        Optional<User> optional = this.findById(id);
        User userOptional = null;
        if(optional.isPresent()){
            User userdb = optional.orElseThrow();
            userdb.setUsername(user.getUsername());
            userdb.setEmail(user.getEmail());
            userOptional = this.save(userdb);
        }
        return Optional.ofNullable(userOptional);
    }

    @Override
    public void remove(Long id) {
        userRepositories.deleteById(id);
    }
}


