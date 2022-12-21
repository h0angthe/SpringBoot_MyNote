package com.hoang.mynote.infra.repository;

import com.hoang.mynote.infra.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    @Query("{userid: '?0'}")
    public List<Note> findByNote(String userid);
    public List<Note> findNotesByUseridAndTags(String userid, String tag);
}
