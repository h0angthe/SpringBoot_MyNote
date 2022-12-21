package com.hoang.mynote.infra.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document

public class Tag {
    @Id
    private String id;
    private String tagname;
    private String userid;
}
