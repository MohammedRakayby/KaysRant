package com.rakayby.blog.controller;

import com.rakayby.blog.constant.ApiEndPoints;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.ARTICLE_CONTROLLER, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ArticleController {

}
