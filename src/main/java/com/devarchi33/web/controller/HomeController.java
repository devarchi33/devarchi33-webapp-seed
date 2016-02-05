package com.devarchi33.web.controller;

/**
 * Created by donghoon on 2016. 1. 22..
 */

import com.devarchi33.web.dao.mongo.UserCrud;
import com.devarchi33.web.domain.ExternalAccountInfo;
import com.devarchi33.web.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserCrud userCrud;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String webHome() {
        logger.debug("Home Page.");
        return "index";
    }

    @RequestMapping(value = "isMember", method = RequestMethod.POST, produces = "plain/text; charset=utf8")
    @ResponseBody
    public String isMember(@RequestParam Long userAccountId) {
        if (userAccountId != null) {
            logger.info("Check userAccountId: " + userAccountId + ".");
            boolean isExists = userCrud.existUserById(userAccountId);
            if (isExists) {
                logger.info("Exist User!");
                return "EXISTUSER";
            } else {
                logger.info("Not Exist User!");
                return "NOTEXISTUSER";
            }
        } else {
            throw new NullPointerException("Required Informatiaon is null...");
        }
    }

    @RequestMapping(value = "createMember", method = RequestMethod.POST, produces = "text/plain; charset=utf8")
    @ResponseBody
    public String createMember(@RequestParam Long userAccountId, @RequestParam String type, @RequestParam String nickName,
                               @RequestParam String profileImg, @RequestParam String thumbnailImg) {
        if (userAccountId != null && type != null && nickName != null &&
                profileImg != null && thumbnailImg != null) {
            ExternalAccountInfo accountInfo = new ExternalAccountInfo(
                    userAccountId, type, nickName, profileImg, thumbnailImg);
            UserInfo user = new UserInfo(userAccountId, accountInfo);
            userCrud.createUser(user, accountInfo);
            logger.info("Create user success");
            return accountInfo.getKakaoNickName();
        } else {
            throw new NullPointerException("Required Informatiaon is null...");
        }
    }
}
