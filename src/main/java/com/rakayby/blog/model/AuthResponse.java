package com.rakayby.blog.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
public class AuthResponse {

    private final String errorMessage;
    private final HttpStatus httpStatus;
    private final String jwt;
    private final Boolean status;

    private AuthResponse(Builder builder) {
        this.errorMessage = builder.errorMessage;
        this.httpStatus = builder.httpStatus;
        this.status = builder.status;
        this.jwt = builder.jwt;
    }

    public static class Builder {

        private String errorMessage;
        private HttpStatus httpStatus;
        private Boolean status;
        private  String jwt;

        public Builder() {
      
        }

        public Builder withMessage(String errorMessage) {
            this.errorMessage = errorMessage;
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

        public AuthResponse build() {
            AuthResponse authResponse = new AuthResponse(this);
            return authResponse;
        }
    }

}
