package com.hoang.mynote.rest.controller;

import com.hoang.mynote.infra.entity.Tag;
import com.hoang.mynote.rest.model.InputCreateTag;
import com.hoang.mynote.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/tag")
    public Object saveTag(@RequestBody InputCreateTag inputCreateTag) {
        return tagService.AddTag(inputCreateTag);
    }
    @GetMapping("/taglist/{userid}")
    public Object listTag(@PathVariable("userid") String userid){
        return tagService.getTaglist(userid);
    }


    @DeleteMapping("/delete/tag/{id}")
    public Object delTag(@PathVariable("id") String id){ return  tagService.deleteTag(id);}
    @PutMapping("/tag/update")
    public Object upTag(@RequestBody InputCreateTag inputCreateTag){
        Tag tag = new Tag();
        tag.setTagname(inputCreateTag.getTagname());
        tag.setUserid(inputCreateTag.getUserid());
        tag.setId(inputCreateTag.getId());
        return tagService.updateTag(tag);
    }

}
