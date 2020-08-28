package com.api.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class User {
    private String login;
    private String avatar_url;

}
