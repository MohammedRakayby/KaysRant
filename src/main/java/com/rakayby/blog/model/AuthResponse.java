package com.rakayby.blog.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
public class AuthResponse {

    private final String message;
    private final HttpStatus httpStatus;
    private final Boolean status;
    private final Object data;

    private AuthResponse(Builder builder) {
        this.message = builder.message;
        this.httpStatus = builder.httpStatus;
        this.status = builder.status;
        this.data = builder.data;
    }

    public static class Builder {

        private String message;
        private HttpStatus httpStatus;
        private Boolean status;
        private Object data;

        public Builder() {

        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder withStatus(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder withData(Object o) {
            this.data = o;
            return this;
        }

        public AuthResponse build() {
            AuthResponse authResponse = new AuthResponse(this);
            return authResponse;
        }
    }

}
