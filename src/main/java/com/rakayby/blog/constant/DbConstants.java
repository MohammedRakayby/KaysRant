package com.rakayby.blog.constant;

/**
 *
 * @author Mohammed.Rakayby
 */
public class DbConstants {

    public static class USER_ATTRIBUTES {

        public static final String NAME = "name";
        public static final String USERNAME = "username";
    }

    public static class TABLES {

        public static final String POSTS = "Posts";
        public static final String USERS = "Users";

        public static class INDECES {

            public static final String POSTS_INDEX = "idx_global_tag";
        }
    }

    public static class POST_ATTRIBUTES {

        public static final String TAG = "tag";
        public static final String DATE = "date";
        public static final String SLUG = "slug";
    }
}
