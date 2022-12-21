package com.hoang.mynote.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter

public class InputCreateTag {
    @Id
    private String id;
    private String tagname;
    private String userid;

}
