package com.devarchi33.web.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by donghoon on 2016. 1. 22..
 */
@Document(collection = "students")
@Data
public class Student {
    private Integer _id;
    private String name;
    private List<Score> scores;

    @Data
    private class Score {
        private String type;
        private Long score;
    }
}
