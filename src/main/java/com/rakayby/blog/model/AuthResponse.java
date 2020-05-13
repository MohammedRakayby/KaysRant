package com.rakayby.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
@AllArgsConstructor
public class AuthResponse {

    private String errorMessage;
    private final String jwt;
}
