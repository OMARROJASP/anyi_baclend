package com.minimarket.ayni.repositories;

import com.minimarket.ayni.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositories extends CrudRepository<User, Long> {
}
