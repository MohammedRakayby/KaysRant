package com.rakayby.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Rakayby
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    private Long id;
    private String title;
    @ToString.Exclude
    private String content;
    private String tag;
    private Date date;
    private Integer readTime;
    @ToString.Exclude
    private String summary;
}
