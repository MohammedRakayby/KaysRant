package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.db.service.PostService;
import com.rakayby.blog.model.Post;
import com.rakayby.blog.model.Response;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

/**
 *
 * @author Mohammed.Rakayby
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.POST_CONTROLLER)
public class PostController {

    private final PostService postService;

    @PostMapping(ApiEndPoints.GenericEndpoints.CREATE)
    public Boolean savePost(@RequestBody Post post) {
        try {
            this.postService.savePost(post);
        } catch (DynamoDbException e) {
            System.out.println("Insertion to table" + DbConstants.TABLES.POSTS + " failed");
            return false;
        }

        System.out.println("Insertion to table" + DbConstants.TABLES.POSTS + " succeeded");
        return true;
    }

    @GetMapping(ApiEndPoints.PostController.GET_ALL)
    public List<Post> getAll() {
        List<Post> posts = this.postService.getAll();

        return posts;
    }

    @GetMapping(ApiEndPoints.PostController.GET_POST_BY_ID)
    public ResponseEntity<?> getById(@RequestParam(required = true) String id) {
        final Post post = this.postService.getById(id);
        if (post != null) {
            return ResponseEntity.ok().body(new Response.Builder()
                    .withData(post)
                    .withMessage("Post Retrieved Successfully")
                    .withStatus(Boolean.TRUE));
        }
        return ResponseEntity.ok().body(new Response.Builder()
                .withMessage("Post With id" + id + " not found")
                .withStatus(Boolean.FALSE));
    }

//    @GetMapping(ApiEndPoints.PostController.GET_POST_BY_SLUG)
//    public ResponseEntity<?> getBySlug(@RequestParam(required = true) String slug) {
//        final Optional<Post> post = this.postService.getBySlug(slug);
//        if (post.isPresent()) {
//            return ResponseEntity.ok().body(new Response.Builder()
//                    .withData(post.get())
//                    .withMessage("Found post with id" + post.map(Post::getId))
//                    .withStatus(Boolean.TRUE)
//                    .build());
//        }
//        return ResponseEntity.ok().body(new Response.Builder()
//                .withMessage("Failed to find post")
//                .withStatus(Boolean.FALSE)
//                .build());
//    }
}
