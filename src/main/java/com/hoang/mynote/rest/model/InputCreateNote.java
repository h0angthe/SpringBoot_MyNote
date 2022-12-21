package com.hoang.mynote.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter

public class InputCreateNote {
    @Id
    private String id;
    private String titlenote;
    private String contentnote;
    private List<String> tags;
    private String userid;
}
