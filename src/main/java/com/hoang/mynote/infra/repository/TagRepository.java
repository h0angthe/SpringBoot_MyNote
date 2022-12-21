package com.hoang.mynote.infra.repository;

import com.hoang.mynote.infra.entity.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {
    @Query("{userid: '?0'}")
    public List<Tag> findByTag(String userid);
}
