package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.db.service.PostService;
import com.rakayby.blog.model.Page;
import com.rakayby.blog.model.Post;
import com.rakayby.blog.model.Response;
import com.rakayby.blog.util.HttpUtils;
import java.util.Map;
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

    @PostMapping(ApiEndPoints.PostController.GET_ALL)
    public ResponseEntity<Response> getAll(@RequestParam(required = false) Integer pageSize, @RequestBody Map<String, Object> exclusiveKey) {
        try {
            Page page = this.postService.getAll(pageSize, HttpUtils.convertToAttributeMap(exclusiveKey));
            return ResponseEntity.ok().body(new Response.Builder()
                    .withData(page)
                    .withMessage("Retrieved " + page.getContentList().size() + " posts")
                    .withStatus(Boolean.TRUE)
                    .build());
        } catch (Exception e) {
            //todo: create a custom exception
            return ResponseEntity.ok().body(new Response.Builder()
                    .withMessage("Failed to retrieve posts")
                    .withStatus(Boolean.FALSE)
                    .build());
        }
    }

    @GetMapping(ApiEndPoints.PostController.GET_POST_BY_ID)
    public ResponseEntity<Response> getById(@RequestParam String id, @RequestParam Long range) {
        try {
            final Post post = this.postService.getById(id, range);
            if (post != null) {
                return ResponseEntity.ok().body(new Response.Builder()
                        .withData(post)
                        .withMessage("Post Retrieved Successfully")
                        .withStatus(Boolean.TRUE)
                        .build());
            }
        } catch (Exception e) {
            System.out.println("err");
        }
        return ResponseEntity.ok().body(new Response.Builder()
                .withMessage("Post With id" + id + " not found")
                .withStatus(Boolean.FALSE)
                    .build());
    }

    @GetMapping(ApiEndPoints.PostController.GET_BY_TAG)
    public ResponseEntity<Response> getByTag(@RequestParam String tag,
                                             @RequestParam(required = false) Integer pageSize,
                                             @RequestBody Map<String, Object> exclusiveKey) {
        try {
            final Page page = this.postService.getByTag(pageSize, HttpUtils.convertToAttributeMap(exclusiveKey), tag);
            return ResponseEntity.ok().body(new Response.Builder()
                    .withData(page)
                    .withMessage("Retrieved " + page.getContentList().size() + " posts under Tag: " + tag)
                    .withStatus(Boolean.TRUE)
                    .build()
            );
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response.Builder()
                    .withMessage("Failed to Retrieve posts under Tag: " + tag)
                    .withStatus(Boolean.FALSE)
                    .build());
        }
    }
}
