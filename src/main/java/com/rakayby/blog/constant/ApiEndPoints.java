package com.rakayby.blog.constant;

/**
 *
 * @author Rakayby
 */
public class ApiEndPoints {

    public static class Controllers {

        public static final String POST_CONTROLLER = "post";
        public static final String USER_CONTROLLER = "user";
        public static final String AUTH_CONTROLLER = "auth";
    }

    public static class GenericEndpoints {

        public static final String CREATE = "create";
        public static final String DELETE = "delete";
        public static final String GET = "get";
        public static final String EDIT = "edit";
    }

    public static class PostController {

        public static final String GET_ALL = "getAll";
        public static final String EDITOR = "editor";
        public static final String GET_POST = "getPost";
    }

    public static class AuthController {

        public static final String LOGIN = "login";
    }
}
