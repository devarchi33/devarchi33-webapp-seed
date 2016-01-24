package com.devarchi33.web.dao.mongo;

import com.devarchi33.web.dao.UserDao;
import com.devarchi33.web.domain.ExternalAccountInfo;
import com.devarchi33.web.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by donghoon on 2016. 1. 23..
 */
@Repository
public class UserCrud implements UserDao {
    private Logger logger = LoggerFactory.getLogger(UserCrud.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Long countUser() {
        logger.info("call user count...");
        Query query = new Query();
        return mongoTemplate.count(query, UserInfo.class);
    }

    @Override
    public Boolean existUserById(Long id) {
        logger.info("checking weather userInfo exsit or not...");
        Query query = new Query(where("externalAccountInfo.accountId").is(id));
        return mongoTemplate.exists(query, UserInfo.class);
    }

    @Override
    public void createUser(UserInfo user, ExternalAccountInfo externalAccountInfo) {
        if (user != null && externalAccountInfo != null) {
            mongoTemplate.insert(user);
            mongoTemplate.insert(externalAccountInfo);
            logger.info("create userInfo success...");
        } else {
            throw new NullPointerException("UserInfo is null...");
        }
    }

    @Override
    public List<UserInfo> getAllUsers() {
        logger.info("find all userInfo...");
        return mongoTemplate.findAll(UserInfo.class);
    }

    @Override
    public UserInfo findUserByEmail(String email) {
        logger.info("find userInfo by email...");
        Query query = new Query(where("email").is(email));
        return mongoTemplate.findOne(query, UserInfo.class);
    }
}
