package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.Post;
import java.util.List;

/**
 *
 * @author mohammed.rakayby
 */
public interface PostRepository {
    public Post save(Post p);
    public Post getById(String id);
    public List<Post> getAll();
    public List<Post> getByTag(String tag);
}
