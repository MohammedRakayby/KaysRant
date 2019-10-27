package com.rakayby.blog.model;

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
@ToString
public class Article {

    private Integer id;
    private String title;
    private String content;
    private String author;
}
