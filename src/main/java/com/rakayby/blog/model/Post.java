package com.rakayby.blog.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rakayby
 */
@Getter
@Setter
public class Post {

    private Long id;
    private String slug;
    private String title;
    private String content;
    private String tag;
    private Date date;
    private Integer readTime;
    private String summary;
}
