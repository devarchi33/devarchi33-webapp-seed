package com.devarchi33.web.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 2016. 1. 23..
 */
@Document(collection = "externalAccountInfo")
@Data
public class ExternalAccountInfo {
    @Id
    private Long accountId;
    private String type;
    //Kakao
    private String kakaoNickName;
    private String kakaoProfileImg;
    private String kakaoThumbnailImg;
    //

    public ExternalAccountInfo() {
    }

    public ExternalAccountInfo(Long accountId, String type, String kakaoNickName, String kakaoProfileImg, String kakaoThumbnailImg) {
        this.accountId = accountId;
        this.type = type;
        this.kakaoNickName = kakaoNickName;
        this.kakaoProfileImg = kakaoProfileImg;
        this.kakaoThumbnailImg = kakaoThumbnailImg;
    }
}
