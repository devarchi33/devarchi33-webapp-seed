package com.devarchi33.web.dao;

import com.devarchi33.web.domain.ExternalAccountInfo;
import com.devarchi33.web.domain.UserInfo;

import java.util.List;

/**
 * Created by donghoon on 2016. 1. 23..
 */
public interface UserDao {
    Long countUser();

    Boolean existUserById(Long id);

    void createUser(UserInfo user, ExternalAccountInfo externalAccountInfo);

    List<UserInfo> getAllUsers();

    UserInfo findUserByEmail(String email);

}
