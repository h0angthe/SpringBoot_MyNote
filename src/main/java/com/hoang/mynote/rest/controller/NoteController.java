package com.hoang.mynote.rest.controller;

import com.hoang.mynote.infra.entity.Note;
import com.hoang.mynote.rest.model.InputCreateNote;
import com.hoang.mynote.rest.model.InputCreateTag;
import com.hoang.mynote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping("/note")
    public Object createNote(@RequestBody Note note){
        return noteService.AddNote(note);
    }

    @GetMapping("/listnote/{userid}")
    public Object getListnote(@PathVariable("userid") String userid){return noteService.getlist(userid);}

    @GetMapping("getnote/{noteid}")
    public Object getNote(@PathVariable("noteid") String noteid){return noteService.getNoteById(noteid);}

    @GetMapping("/listnotebytag/{userid}/{tag}")
    public List<Note> getlistnotebytag(@PathVariable("userid") String userid,@PathVariable("tag") String tag){
        return noteService.getlistbytag(userid,tag);
    }
    @DeleteMapping("/delete/{id}")
    public Object delnote(@PathVariable("id") String id) {return noteService.delnote(id);}

    @PutMapping("/updateNote")
    public Object update(@RequestBody InputCreateNote inputCreateNote){
        return noteService.updatenote(inputCreateNote);
    }
    @DeleteMapping("/deletetagnote")
    public Object deletetagnote(@RequestBody InputCreateNote input){
        return noteService.delTaginNote(input);
    }
}
