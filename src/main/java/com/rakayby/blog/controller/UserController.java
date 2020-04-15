package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.db.facade.UserFacade;
import com.rakayby.blog.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.USER_CONTROLLER, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping(ApiEndPoints.GenericEndpoints.CREATE)
    public Boolean create(@RequestBody User user) {
        //validate
        //call creation methods
        userFacade.create(user);
        return true;
    }
}
