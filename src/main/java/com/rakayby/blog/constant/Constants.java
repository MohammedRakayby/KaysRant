package com.rakayby.blog.constant;

/**
 *
 * @author Mohammed.Rakayby
 */
public class Constants {

    public static final String BEARER = "Bearer";

    public static class ROLES {

        public static final String USER = "user";
        public static final String ADMIN = "admin";
    }

    public enum UserValidation {
        INVALID_USERNAME,
        INVALID_PASSWORD,
        SUCCESS
    }
}
