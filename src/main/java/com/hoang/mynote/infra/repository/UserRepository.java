package com.hoang.mynote.infra.repository;

import com.hoang.mynote.infra.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{name: '?0'}")
    public List<User> findByName(String Name);
}
