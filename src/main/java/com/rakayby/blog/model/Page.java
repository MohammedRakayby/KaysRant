package com.rakayby.blog.model;

import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rakayby
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    private HashMap<String, Object> lastEvaluatedKey;
    private List<Object> contentList;
}
