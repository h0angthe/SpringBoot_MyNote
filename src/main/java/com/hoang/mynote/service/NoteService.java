package com.hoang.mynote.service;

import com.hoang.mynote.infra.entity.Note;
import com.hoang.mynote.infra.entity.Tag;
import com.hoang.mynote.infra.entity.User;
import com.hoang.mynote.infra.repository.NoteRepository;
import com.hoang.mynote.rest.model.InputCreateNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Object AddNote(Note note) {
        if (!StringUtils.hasText(note.getTitlenote()))
            return "Title is empty !!!";
        if (!StringUtils.hasText(note.getContentnote()))
            return "Content is empty !!";
        if (!StringUtils.hasText(note.getUserid()))
            return "Userid is empty !!";

        noteRepository.save(note);
        return "Success!!!";
    }

    public Object getlist(String userid) {
        return noteRepository.findByNote(userid);
    }

    public List<Note> getlistbytag(String userid, String tag) {
        List<Note> notes = noteRepository.findNotesByUseridAndTags(userid, tag);
        if (!CollectionUtils.isEmpty(notes))
            return notes;
        else
            return null;
    }

    public Object getNoteById(String id) {
        return noteRepository.findById(id).get();
    }

    public Object updatenote(InputCreateNote input) {
        if (!StringUtils.hasText(input.getId()))
            return "Id is empty !!";
        if (!StringUtils.hasText(input.getTitlenote()))
            return "Title is empty !!!";
        if (!StringUtils.hasText(input.getContentnote()))
            return "Content is empty !!";
        if (!StringUtils.hasText(input.getUserid()))
            return "Userid is empty !!";

        if (noteRepository.existsById(input.getId())) {
            Note note = new Note();
            note.setTitlenote(input.getTitlenote());
            note.setContentnote(input.getContentnote());
            note.setTags(input.getTags());
            note.setUserid(input.getUserid());
            note.setId(input.getId());
            noteRepository.save(note);
        }
        return null;
    }

    public Object delnote(String id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
        return null;
    }

    public Object delTaginNote(InputCreateNote input) {
        List<Note> noteList = noteRepository.findByNote(input.getUserid());
        for (Note note : noteList) {
            if (!CollectionUtils.isEmpty(note.getTags())) {
                for (int i = 0; i < input.getTags().size(); i++) {
                    if (input.getTags().equals(note.getTags().get(i))) {
                        note.getTags().remove(i);
                    }
                }
            }
            noteRepository.save(note);
        }
        return null;
    }
}
