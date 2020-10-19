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
    private String slug;

    private Date date;
    private String title;
    private String content;
    private String tag;

    private Integer readTime;
    private String summary;
}
