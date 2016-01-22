package com.devarchi33.web.dao.crud;

import com.devarchi33.web.dao.StudentRepository;
import com.devarchi33.web.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 1. 22..
 */
@Document(collection = "students")
@Repository
public class StudentCrud implements StudentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Long schoolCount() {
        Query query = new Query();
        return mongoTemplate.count(query, Student.class);
    }
}
