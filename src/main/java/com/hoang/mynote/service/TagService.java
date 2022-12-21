package com.hoang.mynote.service;

import com.hoang.mynote.infra.entity.Note;
import com.hoang.mynote.infra.entity.Tag;
import com.hoang.mynote.infra.entity.User;
import com.hoang.mynote.infra.repository.NoteRepository;
import com.hoang.mynote.infra.repository.TagRepository;
import com.hoang.mynote.rest.model.InputCreateNote;
import com.hoang.mynote.rest.model.InputCreateTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;
    @Autowired
    NoteRepository noteRepository;

    public Object AddTag(InputCreateTag inputCreateTag){
        if (!StringUtils.hasText(inputCreateTag.getTagname()))
            return "TagName is empty !!!";
        if(!StringUtils.hasText(inputCreateTag.getUserid()))
            return "Userid is empty !!";

        Tag tag = new Tag();
        tag.setTagname(inputCreateTag.getTagname());
        tag.setUserid(inputCreateTag.getUserid());
        tagRepository.save(tag);
        return "Success!!!";
    }

    public Object getTaglist(String userid){
        return tagRepository.findByTag(userid);
    }

    public Object getTagListbyID(String tagid){return tagRepository.findById(tagid);}
    public Object deleteTag(String id){
        if(tagRepository.existsById(id)){
            tagRepository.deleteById(id);
            return "Delete";
        }
        return "Not Delete";
    }
    public Object updateTag(Tag tag){
            if(tagRepository.existsById(tag.getId()) ){
                tag.setTagname(tag.getTagname());
                tag.setUserid(tag.getUserid());
                tag.setId(tag.getId());
                tagRepository.save(tag);
            }
            return null;
    }
//    public Object delTaginNote(InputCreateNote input){
//        if(!StringUtils.hasText(input.getId()))
//            return "Id is empty !!";
//
//        if(!StringUtils.hasText(input.getUserid()))
//            return "Owner is empty !!";
//
//        List<Note> noteList = noteRepository.findByNote(input.getUserid());
//        for(Note note: noteList) {
//            if (!CollectionUtils.isEmpty(note.getTags())) {
//                for (int i = 0; i < input.getTags().size(); i++) {
//                    if(input.getTags().equals(note.getTags().get(i))){
//                        note.getTags().remove(i);
//                    }
//                }
//            }
//            noteRepository.save(note);
//        }
//        return null;
//    }
}
