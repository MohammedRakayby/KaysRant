package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.db.facade.PostFacade;
import com.rakayby.blog.model.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = ApiEndPoints.Controllers.POST_CONTROLLER, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping(ApiEndPoints.GenericEndpoints.CREATE)
    public Boolean savePost(@RequestBody Post post) {
        return this.postFacade.savePost(post);
    }

    @GetMapping(ApiEndPoints.PostController.GET_ALL)
    public List<Post> getAll() {
        return this.postFacade.getAll();
    }

    @GetMapping(ApiEndPoints.PostController.EDITOR)
    public Boolean editorSecurity() {
        return true;
    }

    @GetMapping(ApiEndPoints.PostController.GET_POST)
    public ResponseEntity<?> getById(@RequestParam(required = true) Integer id) {
        final Optional post = this.postFacade.getById(id);
        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        }
        return ResponseEntity.ok("Not found");
    }
}
