package com.hoang.mynote.infra.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document

public class Note {
    @Id
    private String id;
    private String titlenote;
    private String contentnote;
    private List<String> tags;
    private String userid;
}
