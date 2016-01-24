package com.devarchi33.web.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 2016. 1. 23..
 */
@Document(collection = "userInfo")
@Data
public class UserInfo {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer certify = 0; //0 : 미인증 , 1 : 인증

    @DBRef
    private ExternalAccountInfo externalAccountInfo;

    public UserInfo() {
    }

    public UserInfo(Long id, ExternalAccountInfo externalAccountInfo) {
        this.id = id;
        this.externalAccountInfo = externalAccountInfo;
    }
}
