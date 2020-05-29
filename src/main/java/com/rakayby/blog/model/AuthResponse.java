package com.rakayby.blog.model;

import lombok.Getter;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
public class AuthResponse {

    private final String errorMessage;
    private final Integer httpStatus;
    private final String jwt;

    private AuthResponse(Builder builder) {
        this.errorMessage = builder.errorMessage;
        this.httpStatus = builder.httpStatus;
        this.jwt = builder.jwt;
    }

    public static class Builder {

        private String errorMessage;
        private Integer httpStatus;
        private final String jwt;

        public Builder(String jwt) {
            this.jwt = jwt;
        }

        public Builder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public Builder withHttpStatus(Integer httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public AuthResponse build() {
            AuthResponse authResponse = new AuthResponse(this);
            return authResponse;
        }
    }

}
