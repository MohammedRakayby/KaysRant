package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.db.facade.UserFacade;
import com.rakayby.blog.model.User;
import com.rakayby.blog.util.UserUtils;
import com.rakayby.blog.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.USER_CONTROLLER, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    //change returns to response entity
    private final UserFacade userFacade;
    private final UserUtils userUtils;
    
    @PostMapping(ApiEndPoints.GenericEndpoints.CREATE)
    public Boolean create(@RequestBody User user) {
        //validate
        //call creation methods
        if (UserValidator.isValidUser(user)) {
            userUtils.encodeUserPassword(user);
            if (userFacade.create(user)) {
                return true;
            }
        }
        return false;
    }
    
    @GetMapping(ApiEndPoints.GenericEndpoints.GET)
    public User getUser(@RequestParam(required = true) String username) {
        return userFacade.loadUserByUsername(username);
    }
}
